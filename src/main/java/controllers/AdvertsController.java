package controllers;

import db.DBAdvert;
import db.DBHelper;
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


public class AdvertsController {

    public AdvertsController() {
        this.setupEndPoints();
    }

    public void setupEndPoints() {


//        INDEX
        get("/adverts", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");


            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/adverts/cars", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");


            List<Advert> adverts = DBAdvert.getCategorysAdverts(CategoryType.CARS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/adverts/furniture", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");

            List<Advert> adverts = DBAdvert.getCategorysAdverts(CategoryType.FURNITURE);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/adverts/cars", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");


            List<Advert> adverts = DBAdvert.getCategorysAdverts(CategoryType.CARS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


//        NEW
        get("/adverts/new", (request, response) -> {
//
            Map<String, Object> model = new HashMap();
            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

//      CREATE
        post("/adverts", (req, res) -> {

            String title = req.queryParams("title");
            String description = req.queryParams("description");
            String categoryValue = req.queryParams("category");
            CategoryType category = CategoryType.valueOf(categoryValue.toUpperCase());
            double price = Double.parseDouble(req.queryParams("price"));
            String location =  req.queryParams("location");
            String sellerName =  req.queryParams("seller_name");
            String newEmail = req.queryParams("email");
            User newUser = new User( sellerName, newEmail);
            DBHelper.save(newUser);
            String imageUrl =  req.queryParams("image_url");
            String adStatus =  req.queryParams("ad_status");

            Advert newAdvert = new Advert(title, description, category, price, location, newUser, imageUrl, adStatus);
            DBHelper.save(newAdvert);

            res.redirect("/adverts");

            return null;
        }, new VelocityTemplateEngine());


//        SHOW
        get("/adverts/:id", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/adverts/show.vtl");
            int advertId = Integer.parseInt(request.params(":id"));
            Advert advert = DBHelper.find(Advert.class, advertId);
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


//        EDIT
        get("/adverts/:id/edit", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/edit.vtl");
            int advertId = Integer.parseInt(request.params(":id"));
            Advert advert = DBHelper.find(Advert.class, advertId);
            model.put("advert", advert);
            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            model.put("categories", categories);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }

}
