package com.noroff.mefit.services.workout;

import com.noroff.mefit.models.Workout;
import com.noroff.mefit.services.CrudService;

import java.util.List;
import java.util.Set;

public interface WorkoutService extends CrudService<Workout, Integer> {
    void addExercises(int id, List<Integer> exerciseId);
}
