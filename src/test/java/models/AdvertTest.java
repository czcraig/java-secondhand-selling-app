package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvertTest {

    Advert advert;
    User user1;

    @Before
    public void setUp()  {
        user1 = new User("Iona", "iona@gmail.com");
        advert = new Advert("Bike for sale", "Hardly used", CategoryType.BICYLE, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");
    }

    @Test
    public void getCategory() {
        assertEquals(CategoryType.BICYLE, advert.getCategory());
    }

    @Test
    public void setCategory() {
        advert.setCategory(CategoryType.CAR);
        assertEquals(CategoryType.CAR, advert.getCategory());
    }

    @Test
    public void getPrice() {
        assertEquals(35, advert.getPrice(), 0.01);
    }

    @Test
    public void setPrice() {
        advert.setPrice(20);
        assertEquals(20, advert.getPrice(), 0.01);
    }

    @Test
    public void getLocation() {
        assertEquals("Edinburgh", advert.getLocation());
    }

    @Test
    public void setLocation() {
        advert.setLocation("fife");
        assertEquals("fife", advert.getLocation());
    }

    @Test
    public void getSeller() {
        assertEquals(user1, advert.getSeller());
    }


    @Test
    public void getImage_url() {
        assertEquals("public/images/bike.jpg", advert.getImage_url());
    }

    @Test
    public void setImage_url() {
        advert.setImage_url("public/images/bike2.jpg");
        assertEquals("public/images/bike2.jpg", advert.getImage_url());
    }

    @Test
    public void getAd_status() {
        assertEquals("For Sale", advert.getAd_status());
    }

    @Test
    public void setAd_status() {
        advert.setAd_status("On hold");
        assertEquals("On hold", advert.getAd_status());

    }
}