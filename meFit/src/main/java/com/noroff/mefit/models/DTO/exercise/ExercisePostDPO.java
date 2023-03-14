package com.noroff.mefit.models.DTO.exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExercisePostDPO {
    private String name;
    private String description;
    private String musclegroup;
    private String vidlink;
    private Integer repetitions;
}
