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

//        CARS
        get("/adverts/cars", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/cars.vtl");
            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.CARS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Furniture
        get("/adverts/furniture", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/furniture.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.FURNITURE);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Bicycles
        get("/adverts/bicycles", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/bicycles.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.BICYCLES);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Technology
        get("/adverts/technology", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/technology.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.TECHNOLOGY);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        // Sports
        get("/adverts/sports", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/sports.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.SPORTS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Instruments
        get("/adverts/instruments", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/instruments.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.INSTRUMENTS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Clothes
        get("/adverts/clothes", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/clothes.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.CLOTHES);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Appliances
        get("/adverts/appliances", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/appliances.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.APPLIANCES);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        // Toys
        get("/adverts/toys", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/toys.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.TOYS);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        //Free
        get("/adverts/free", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/free.vtl");

            List<Advert> adverts = DBAdvert.getAllAdvertsForCategory(CategoryType.FREE);
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
//            int userId = Integer.parseInt(request.params(":id"));
//            User user = DBHelper.find(User.class, userId);
//            model.put("user", user);
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



        // UPDATE
        post("adverts/:id", (request, response) -> {
            int advertId = Integer.parseInt(request.params(":id"));
            String title = request.queryParams("title");
            String description = request.queryParams("description");
            String categoryValue = request.queryParams("category");
            CategoryType category = CategoryType.valueOf(categoryValue.toUpperCase());
            double price = Double.parseDouble(request.queryParams("price"));
            String location =  request.queryParams("location");
            String sellerName =  request.queryParams("seller_name");
            String newEmail = request.queryParams("email");
            User newUser = new User( sellerName, newEmail);
            DBHelper.save(newUser);
            String imageUrl =  request.queryParams("image_url");
            String adStatus =  request.queryParams("ad_status");

            Advert advert = DBHelper.find(Advert.class, advertId);

            advert.setTitle(title);
            advert.setDescription(description);
            advert.setCategory(category);
            advert.setPrice(price);
            advert.setLocation(location);
            advert.setImageUrl(imageUrl);
            advert.setAdStatus(adStatus);
            DBHelper.update(advert);

            response.redirect("/adverts");

            return null;
        }, new VelocityTemplateEngine());

    }

}
