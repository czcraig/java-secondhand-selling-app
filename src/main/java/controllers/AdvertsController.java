package controllers;

import db.DBHelper;
import models.Advert;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;


public class AdvertsController {

    public AdvertsController() {
        this.setupEndPoints();
    }

    public void setupEndPoints() {
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/adverts", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/adverts/index.vtl");


            List<Advert> adverts = DBHelper.getAll(Advert.class);
            model.put("adverts", adverts);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);


        get("/adverts/:id", (request, response) -> {

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/adverts/show.vtl");
            int advertId = Integer.parseInt(request.params(":id"));
            Advert advert = DBHelper.find(Advert.class, advertId);
            model.put("advert", advert);
            return new ModelAndView(model, "templates/layout.vtl");

        }, velocityTemplateEngine);

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
