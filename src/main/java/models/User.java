package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String name;
    private String email;
    private List<Advert> selling;
    private List<Advert> favourites;
    private int rating;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.favourites = new ArrayList<Advert>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "seller")
    public List<Advert> getSelling() {
        return selling;
    }

    public void setSelling(List<Advert> selling) {
        this.selling = selling;
    }

    public void addAdvertToSelling(Advert advert) {
        selling.add(advert);
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "adverts_users",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "advert_id", nullable = false, updatable = false)})
    public List<Advert> getFavourites() {
        return favourites;
    }


    public void setFavourites(List<Advert> favourites) {
        this.favourites = favourites;
    }

    public void addAdvertToFavourites(Advert advert) {
        favourites.add(advert);
    }

    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
