package de.goldenboys.housekeepingplanner.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    String username;
    @OneToMany
    List<Household> households;
    String email;
    String password;

}
