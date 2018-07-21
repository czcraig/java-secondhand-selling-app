package db;

import models.Advert;
import models.CategoryType;
import models.User;

import java.util.List;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(User.class);


        User user1 = new User("Bill", "bill@hotmail.com");
        DBHelper.save(user1);
        User user2 = new User("Jess", "jess@gmail.com");
        DBHelper.save(user2);
        User user3 = new User("Chris", "chris@gmail.com");
        DBHelper.save(user3);

        Advert advert1 = new Advert("Bike for sale", "Hardly used", CategoryType.BICYCLES, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");
        DBHelper.save(advert1);

        Advert advert2 = new Advert("Guitar for Sale", "Hardly used", CategoryType.INSTRUMENTS, 85.00, "Edinburgh", user1, "public/images/guitar.jpg", "For Sale");
        DBHelper.save(advert2);

        Advert advert3 = new Advert("HD Television for Sale", "Good condition 40", CategoryType.TECHNOLOGY, 75.00, "Edinburgh", user2, "public/images/tv.jpg", "For Sale");
        DBHelper.save(advert3);


        Advert advert4 = new Advert("Ford Focus for Sale", "Good condition Blue", CategoryType.CARS, 375.00, "Edinburgh", user1, "public/images/car.jpg", "For Sale");
        DBHelper.save(advert4);

        Advert advert5 = new Advert("Sofa for Sale", "Good condition and comfy leather sofa", CategoryType.FURNITURE, 150.00, "Glasgow", user2, "public/images/sofa.jpg", "For Sale");
        DBHelper.save(advert5);

        Advert advert6 = new Advert("Kettle for Sale", "Pretty good condition", CategoryType.APPLIANCES, 5.00, "Edinburgh", user2, "public/images/kettle.jpg", "For Sale");
        DBHelper.save(advert6);

        Advert advert7 = new Advert("Football Boots", "Never worn and in fantastic condition", CategoryType.SPORTS, 20.00, "Fife", user1, "public/images/football_boots.jpg", "For Sale");
        DBHelper.save(advert7);

        Advert advert8 = new Advert("Dinning Room table", "old table, still not back condition", CategoryType.FREE, 0.00, "Aberdeen", user3, "public/images/table.jpg", "For Sale");
        DBHelper.save(advert8);

        Advert advert9 = new Advert("Dress", "Fantastic condition, only wore once", CategoryType.CLOTHES, 20.00, "Aberdeen", user3, "public/images/dress.jpg", "For Sale");
        DBHelper.save(advert9);

        Advert advert10 = new Advert("Ninja Turtle figure", "its a toy", CategoryType.TOYS, 5.00, "Fife", user3, "public/images/ninja_turtle.jpg", "For Sale");
        DBHelper.save(advert10);


    }
}
