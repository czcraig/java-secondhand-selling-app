package db;

import models.Advert;
import models.CategoryType;
import models.User;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Advert.class);
        DBHelper.deleteAll(User.class);

        User user1 = new User("Bill", "bill@hotmail.com");
        User user2 = new User("Jess", "jess@gmail.com");

        Advert advert1 = new Advert("Bike for sale", "Hardly used", CategoryType.BICYLE, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");

        Advert advert2 = new Advert("Guitar for Sale", "Hardly used", CategoryType.INSTRUMENT, 85.00, "Edinburgh", user1, "public/images/guitar.jpg", "For Sale");



    }
}
