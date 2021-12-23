package de.goldenboys.housekeepingplanner.model;

import de.goldenboys.housekeepingplanner.enums.Repitition;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String title;
    public String description;
    public LocalDateTime startTime;
    public int duration;
    public Repitition repitition;
    @ManyToOne
    public User assignedTo;

}
