package de.goldenboys.housekeepingplanner.model;

import de.goldenboys.housekeepingplanner.enums.Repition;

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
    public Repition repition;
    @ManyToOne
    public User assignedTo;

}
