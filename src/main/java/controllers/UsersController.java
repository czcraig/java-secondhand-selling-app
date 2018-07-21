package controllers;


import db.DBAdvert;
import db.DBHelper;
import models.Advert;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

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



        get("/users/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

        model.put("template", "templates/users/show.vtl");
        int userId = Integer.parseInt(request.params(":id"));
        User user = DBHelper.find(User.class, userId);
        model.put("user", user);
         List<Advert> adverts = DBAdvert.getUsersAdverts(user);
         model.put("adverts", adverts);
        return new ModelAndView(model, "templates/layout.vtl");

    }, new VelocityTemplateEngine());
    }
}
