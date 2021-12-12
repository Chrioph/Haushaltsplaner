package de.goldenboys.housekeepingplanner.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    String username;
    @ManyToMany
    List<Household> households;
    String email;
    String password;

}
