package com.noroff.mefit.models.DTO.workout;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ExerciseToWorkoutDTO {
    private List<Integer> exerciseIds;
}
