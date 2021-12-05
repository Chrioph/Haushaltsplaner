package de.goldenboys.housekeepingplanner.model;

import de.goldenboys.housekeepingplanner.enums.Repition;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String description;
    LocalDateTime startTime;
    int duration;
    Repition repition;
    @OneToOne
    User assignedTo;

}
