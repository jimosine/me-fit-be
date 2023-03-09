package com.noroff.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String musclegroup;
    private String vidlink;
    private Integer repetitions;
    @Column(columnDefinition = "boolean default false")
    private Boolean compleded;

    //RelationShips
    @ManyToMany(mappedBy = "exercises")
    private Set<Workout> workouts;

}
