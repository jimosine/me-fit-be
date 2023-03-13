package com.noroff.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private LocalDate enddate;
    @Column(columnDefinition = "boolean default false" )
    private Boolean achieved = false;

    //RelationShips
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToMany
    private Set<Workout> workouts;
    @ManyToMany
    private Set<Program> programs;


}
