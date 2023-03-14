package com.noroff.mefit.controllers;

import com.noroff.mefit.models.DTO.workout.ExerciseToWorkoutDTO;
import com.noroff.mefit.models.DTO.workout.WorkoutPostDPO;
import com.noroff.mefit.models.Workout;
import com.noroff.mefit.services.workout.WorkoutService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/workout")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final ModelMapper mapper;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;

        mapper =new ModelMapper();
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(workoutService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(workoutService.findById(id));
    }

    @PostMapping()
    public ResponseEntity addNewWorkout(@RequestBody WorkoutPostDPO workoutPostDPO) throws URISyntaxException {
        Workout workout = mapper.map(workoutPostDPO, Workout.class);
        workoutService.add(workout);
        int entity = workout.getId();
        URI uri = new URI("workout/" + entity);
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("{id}")
    public ResponseEntity updateWorkout(@RequestBody Workout workout, @PathVariable int id){
        workout.setId(id);
        workoutService.update(workout);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/exercise")
    public ResponseEntity updateExercise(@PathVariable int id, @RequestBody ExerciseToWorkoutDTO exerciseToWorkoutDTO){
        workoutService.addExercises(id, exerciseToWorkoutDTO.getExerciseIds());
        return ResponseEntity.noContent().build();
    }
}
