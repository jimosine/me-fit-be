package com.noroff.mefit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;

    //RelationShips
    @OneToOne()
    @JoinColumn(name = "users_id")
    private Users users;

    @OneToMany(mappedBy = "profile")
    private Set<Goal> goals;

}
