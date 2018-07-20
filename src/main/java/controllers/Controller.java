package controllers;

import db.DBHelper;
import db.Seeds;
import models.Advert;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class Controller {
    public static void main(String[] args) {

        Seeds.seedData();


        AdvertsController advertsController = new AdvertsController();
        UsersController usersController = new UsersController();

        VelocityTemplateEngine velocityTemplateEngine = new
                VelocityTemplateEngine();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
