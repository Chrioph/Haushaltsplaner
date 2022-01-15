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
    @ManyToOne
    public Household household;

    public Task(String title, String description, LocalDateTime startTime, int duration, Repitition repitition,
                User user, Household household) {
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.duration = duration;
        this.repitition = repitition;
        this.assignedTo = user;
        this.household = household;
    }

    public Task() {

    }
}
