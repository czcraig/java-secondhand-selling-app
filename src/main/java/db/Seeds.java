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

        Advert advert1 = new Advert("Bike for sale", "Hardly used", CategoryType.BICYCLES, 35.00, "Edinburgh", user1, "/bike.jpeg", "For Sale");
        DBHelper.save(advert1);

        Advert advert2 = new Advert("Guitar for Sale", "Hardly used", CategoryType.INSTRUMENTS, 85.00, "Edinburgh", user1, "/guitar.jpg", "For Sale");
        DBHelper.save(advert2);

        Advert advert3 = new Advert("HD Television for Sale", "Good condition 40", CategoryType.TECHNOLOGY, 75.00, "Edinburgh", user2, "/tv.jpeg", "For Sale");
        DBHelper.save(advert3);


        Advert advert4 = new Advert("Ford Focus for Sale", "Good condition Blue", CategoryType.CARS, 375.00, "Edinburgh", user1, "/Ford_Focus.jpg", "For Sale");
        DBHelper.save(advert4);

        Advert advert5 = new Advert("Sofa for Sale", "Good condition and comfy leather sofa", CategoryType.FURNITURE, 150.00, "Glasgow", user2, "/sofa.jpg", "For Sale");
        DBHelper.save(advert5);

        Advert advert6 = new Advert("Kettle for Sale", "Pretty good condition", CategoryType.APPLIANCES, 5.00, "Edinburgh", user2, "/kettle.jpeg", "For Sale");
        DBHelper.save(advert6);


        Advert advert8 = new Advert("Dining Room table", "old table, still not back condition", CategoryType.FREE, 0.00, "Aberdeen", user3, "/table.jpg", "For Sale");
        DBHelper.save(advert8);

        Advert advert9 = new Advert("Dress", "Fantastic condition, only wore once", CategoryType.CLOTHES, 20.00, "Aberdeen", user3, "/dress.jpg", "For Sale");
        DBHelper.save(advert9);

        Advert advert10 = new Advert("Ninja Turtle figures", "its a toy", CategoryType.TOYS, 5.00, "Fife", user3, "/TMNT toy.jpg", "For Sale");
        DBHelper.save(advert10);

        Advert advert11 = new Advert("Bmx for sale",  "still in good condition, just dont have time to use it anymore", CategoryType.BICYCLES, 80.00, "Fife", user3, "/bmx.jpeg", "For Sale");
        DBHelper.save(advert11);

        Advert advert12 = new Advert("Acoustic guitar",  "Merida Trajan T-5 Classical Guitar - Natural", CategoryType.INSTRUMENTS, 120.00, "Fife", user2, "/acoustic guitar.jpg", "For Sale");
        DBHelper.save(advert12);

        Advert advert13 = new Advert("Free lamp", "still reasonably good condition, free to good home", CategoryType.FREE, 0.00, "Glasgow", user1, "/lamp.jpg", "For Sale");
        DBHelper.save(advert13);

        Advert advert14 = new Advert("Toaster for sale", "barely used, 4 slice toaster", CategoryType.APPLIANCES, 30.00, "Fife", user3, "/toaster.jpg", "For Sale");
        DBHelper.save(advert14);

        Advert advert15 = new Advert("Shirt for sale", "Medium mans shirt, never worn", CategoryType.CLOTHES, 15.00, "Dundee", user1, "/shirt.jpeg", "For Sale");
        DBHelper.save(advert15);

        Advert advert16 = new Advert("Leather corner couch for sale", "really good condition, only a few years old", CategoryType.FURNITURE, 500.00, "Fife", user2, "/leather_corner_sofa.jpeg", "For Sale");
        DBHelper.save(advert16);

        Advert advert17 = new Advert("Ipad for sale", "still in reasonable condition, older model but still works well.", CategoryType.TECHNOLOGY, 65.00, "Glasgow", user3, "/ipad.jpeg", "For Sale");
        DBHelper.save(advert17);

        Advert advert18 = new Advert("Reliant Robin for sale", "classic car, needs a little work but still in running order", CategoryType.CARS, 5000.00, "Edinburgh", user2, "/reliant_robin.jpg", "For Sale");
        DBHelper.save(advert18);

        Advert advert19 = new Advert("Leather jacket", "bit worn but quality leather jacket", CategoryType.CLOTHES, 70.00, "Aberdeen", user2, "/leather_jacket.jpg", "For Sale");
        DBHelper.save(advert19);

        Advert advert20 = new Advert("Toy cars", "in perfect working order", CategoryType.TOYS, 4.00, "Dundee", user1, "/toy_cars.jpeg", "For Sale");
        DBHelper.save(advert20);

        Advert advert21 = new Advert("Mountain bike for sale",  "unwanted xmas present", CategoryType.BICYCLES, 150.00, "Fife", user2, "/mountain_bike.jpeg", "For Sale");
        DBHelper.save(advert21);

        Advert advert22 = new Advert("Drum kit for sale",  "good drum kit for beginners", CategoryType.INSTRUMENTS, 180.00, "Edinburgh", user3, "/drum kit.jpg", "For Sale");
        DBHelper.save(advert22);

        Advert advert23 = new Advert("Tv stand", "still reasonably good condition, free to good home", CategoryType.FREE, 0.00, "Aberdeen", user3, "/tv_stand.jpeg", "For Sale");
        DBHelper.save(advert23);

        Advert advert24 = new Advert("Microwave for sale", "cheap and in good condition", CategoryType.APPLIANCES, 15.00, "Glasgow", user2, "/microwave.jpeg", "For Sale");
        DBHelper.save(advert24);

        Advert advert25 = new Advert("leather belt", "quality leather, size 32 man", CategoryType.CLOTHES, 5.00, "Dundee", user1, "/belt.jpeg", "For Sale");
        DBHelper.save(advert25);

        Advert advert26 = new Advert("Coffee table", "glass coffee table, ", CategoryType.FURNITURE, 500.00, "Fife", user2, "/coffee_table.jpeg", "For Sale");
        DBHelper.save(advert26);

        Advert advert27 = new Advert("Sound bar", "still in working order", CategoryType.TECHNOLOGY, 40.00, "Edinburgh", user1, "/sound bar.jpg", "For Sale");
        DBHelper.save(advert27);

        Advert advert28 = new Advert("BMW for sale", "three series with only one previous owner", CategoryType.CARS, 5000.00, "Edinburgh", user2, "/bmw.jpeg", "For Sale");
        DBHelper.save(advert28);





//
        DBUser.addFavouriteAdToUser(user1, advert10);
        DBUser.addFavouriteAdToUser(user1, advert9);

        DBUser.addRatingToUser(user1,3);
        DBUser.addRatingToUser(user2,1);
        DBUser.addRatingToUser(user3,5);

    }
}
