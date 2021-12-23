package de.goldenboys.housekeepingplanner.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    String username;
    @ManyToMany
    List<Household> households;
    String email;
    String password;

    public User(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
        this.households = new ArrayList<>();
    }

    public User() {

    }
}
