package models;

import db.DBAdvert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvertTest {

    Advert advert;
    User user1;

    @Before
    public void setUp()  {
        user1 = new User("Iona", "iona@gmail.com");
        advert = new Advert("Bike for sale", "Hardly used", CategoryType.BICYCLES, 35.00, "Edinburgh", user1, "public/images/bike.jpg", "For Sale");
    }

    @Test
    public void getCategory() {
        assertEquals(CategoryType.BICYCLES, advert.getCategory());
    }

    @Test
    public void setCategory() {
        advert.setCategory(CategoryType.CARS);
        assertEquals(CategoryType.CARS, advert.getCategory());
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
    public void getImageUrl() {
        assertEquals("public/images/bike.jpg", advert.getImageUrl());
    }

    @Test
    public void setImageUrl() {
        advert.setImageUrl("public/images/bike2.jpg");
        assertEquals("public/images/bike2.jpg", advert.getImageUrl());
    }

    @Test
    public void getAdStatus() {
        assertEquals("For Sale", advert.getAdStatus());
    }

    @Test
    public void setAdStatus() {
        advert.setAdStatus("On hold");
        assertEquals("On hold", advert.getAdStatus());

    }





}