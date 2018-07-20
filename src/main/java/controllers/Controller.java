package controllers;

import db.DBHelper;
import db.Seeds;
import models.Advert;
import models.CategoryType;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Controller {
    public static void main(String[] args) {

        staticFileLocation("/public");
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

        get("/buy", (request, response) -> {
            Map<String, Object> model = new HashMap();
            List<CategoryType> categories = Arrays.asList(CategoryType.values());
            model.put("categories", categories);
            model.put("template", "templates/buy.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/sell", (request, response) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/sell.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


    }
}
