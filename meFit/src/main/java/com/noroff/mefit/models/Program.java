package com.noroff.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type;
    @Column(columnDefinition = "boolean default false")
    private Boolean completed = false;

    //RelationShips
    @ManyToMany(mappedBy = "programs")
    private Set<Goal> goals;
    @ManyToMany()
    private Set<Workout> workouts;

}
