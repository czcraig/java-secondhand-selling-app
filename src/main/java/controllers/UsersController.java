package controllers;


import db.DBAdvert;
import db.DBHelper;
import db.DBUser;
import models.Advert;
import models.CategoryType;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class UsersController {

    public UsersController() {
        this.setupEndPoints();
    }

    public void setupEndPoints() {

        get("/users", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/index.vtl");
            List<User> users = DBHelper.getAll(User.class);
            model.put("users", users);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        get("/users/:id/selling", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/users/selling.vtl");
            int userId = Integer.parseInt(request.params(":id"));
            User user = DBHelper.find(User.class, userId);
            model.put("user", user);
            List<Advert> adverts = DBAdvert.getUsersSellingAdverts(user);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/users/:id/favourites", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/users/favourites.vtl");
            int userId = Integer.parseInt(request.params(":id"));
            User user = DBHelper.find(User.class, userId);
            model.put("user", user);
            List<Advert> adverts = DBUser.getUsersFavouriteAdverts(user);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


//        NEW
        get("/users/new", (request, response) -> {
//
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/users/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        get("/users/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/users/show.vtl");
            int userId = Integer.parseInt(request.params(":id"));
            User user = DBHelper.find(User.class, userId);
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

//      CREATE
        post("/users", (req, res) -> {

            String name = req.queryParams("name");
            String email = req.queryParams("email");
            User newUser = new User( name, email);
            DBHelper.save(newUser);


            res.redirect("/users");

            return null;
        }, new VelocityTemplateEngine());


//        EDIT
        get("/users/:id/edit", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/users/edit.vtl");
            int userId = Integer.parseInt(request.params(":id"));
            User user = DBHelper.find(User.class, userId);
            model.put("user", user);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());



        // UPDATE
        post("users/:id", (request, response) -> {
            int userId = Integer.parseInt(request.params(":id"));
            User userToUpdate = DBHelper.find(User.class, userId);

            int rating = Integer.parseInt(request.queryParams("rating-input-1"));

            userToUpdate.setRating(rating);
            DBHelper.update(userToUpdate);

            response.redirect("/users");

            return null;
        }, new VelocityTemplateEngine());

    }

}

