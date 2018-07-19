package controllers;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnySimpleDV;
import db.DBHelper;
import models.Advert;
import models.CategoryType;
import models.User;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

//        INDEX
        get("/adverts", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");


            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


//        NEW
        get("/adverts/new", (request, response) -> {

            Map<String, Object> model = new HashMap();
            List<CategoryType> categories = DBHelper.getAll(CategoryType.class);
            model.put("categories", categories);
            model.put("template", "templates/adverts/create.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);

//      CREATE
        post("/adverts", (req, res) -> {

            int advertId = Integer.parseInt(req.queryParams("department"));
            Advert advert = DBHelper.find(Advert.class, advertId);

            String title = req.queryParams("title");
            String description = req.queryParams("description");
            CategoryType category = CategoryType.valueOf(Advert <CategoryType> category, (req.queryParams("category")));
            double price = Double.parseDouble(req.queryParams("price"));
            String location =  req.queryParams("location");
            User seller =  req.queryParams("seller");
            String imageUrl =  req.queryParams("image_url");
            String adStatus =  req.queryParams("ad_status");

            Advert newAdvert = new Advert(title, description, category, price, location, seller, imageUrl, adStatus);
            DBHelper.save(newAdvert);

            res.redirect("/adverts");

            return null;
        }, velocityTemplateEngine);


//        SHOW
        get("/adverts/:id", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/adverts/show.vtl");
            int advertId = Integer.parseInt(request.params(":id"));
            Advert advert = DBHelper.find(Advert.class, advertId);
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);


//        EDIT
        get("/adverts/:id/edit", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/adverts/edit.vtl");
            int advertId = Integer.parseInt(request.params(":id"));
            Advert advert = DBHelper.find(Advert.class, advertId);
            model.put("advert", advert);
            List<Advert> departments = DBHelper.getAll(Advert.class);
            model.put("departments", departments);
            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }

}
