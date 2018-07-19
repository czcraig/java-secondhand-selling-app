package controllers;

import models.Seeds;
import spark.template.velocity.VelocityTemplateEngine;

public class Controller {
    public static void main(String[] args) {
        AdvertsController advertsController = new AdvertsController();
        UsersController usersController = new UsersController();

        Seeds.seedData();

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
    }
}
