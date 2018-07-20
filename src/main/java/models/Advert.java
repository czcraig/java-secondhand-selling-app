package models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="adverts")
public class Advert {

private int id;
private String title;
private String description;
private CategoryType category;
private double price;
@Column(nullable = false)
@Temporal(TemporalType.TIMESTAMP)
@CreationTimestamp
private Date updatedAt;
private String location;
private User seller;
private String imageUrl;
private String adStatus;


    public Advert() {
    }

    public Advert(String title, String description, CategoryType category, double price, String location, User seller, String imageUrl, String adStatus) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.location = location;
        this.seller = seller;
        this.imageUrl = imageUrl;
        this.adStatus = adStatus;
        this.updatedAt = new Date(System.currentTimeMillis());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name= "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "category")
    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }


    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "ad_status")
    public String getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(String ad_status) {
        this.adStatus = ad_status;
    }
}
