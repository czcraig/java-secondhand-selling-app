package models;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    Advert advert;
    User user1;

    @Before
    public void setUp()  {
        user1 = new User("Iona", "iona@gmail.com");
        advert = new Advert("Bike for sale", "Hardly used", CategoryType.BICYCLES, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");
    }


}
