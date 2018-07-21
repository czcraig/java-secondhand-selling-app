package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String name;
    private String email;
    private List<Advert> selling;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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


}
