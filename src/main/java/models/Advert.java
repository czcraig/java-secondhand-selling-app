package models;

import java.sql.Timestamp;

public class Advert {

private int id;
private String title;
private String description;
private CategoryType category;
private double price;
private Timestamp date;
private String location;
private User seller;
private String image_url;
private String ad_status;



    public Advert(String title, String description, CategoryType category, double price, Timestamp date, String location, User seller, String image_url, String ad_status) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.date = date;
        this.location = location;
        this.seller = seller;
        this.image_url = image_url;
        this.ad_status = ad_status;
    }
}
