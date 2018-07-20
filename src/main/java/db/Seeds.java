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

        Advert advert1 = new Advert("Bike for sale", "Hardly used", CategoryType.BICYLES, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");
        DBHelper.save(advert1);

        Advert advert2 = new Advert("Guitar for Sale", "Hardly used", CategoryType.INSTRUMENTS, 85.00, "Edinburgh", user1, "public/images/guitar.jpg", "For Sale");
        DBHelper.save(advert2);

        Advert advert3 = new Advert("HD Television for Sale", "Good condition 40", CategoryType.TECHNOLOGY, 75.00, "Edinburgh", user2, "public/images/tv.jpg", "For Sale");
        DBHelper.save(advert3);


        Advert advert4 = new Advert("Ford Focus for Sale", "Good condition Blue", CategoryType.CARS, 375.00, "Edinburgh", user1, "public/images/car.jpg", "For Sale");
        DBHelper.save(advert4);
    }
}
