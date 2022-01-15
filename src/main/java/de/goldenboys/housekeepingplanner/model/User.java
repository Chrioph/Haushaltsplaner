package de.goldenboys.housekeepingplanner.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    public @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    public String username;
    public String email;
    public String password;

    public User(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

}
