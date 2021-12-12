package de.goldenboys.housekeepingplanner.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Household {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @ManyToMany
    List<User> users;
}
