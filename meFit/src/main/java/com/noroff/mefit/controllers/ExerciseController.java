package com.noroff.mefit.controllers;

import com.noroff.mefit.models.DTO.exercise.ExercisePostDPO;
import com.noroff.mefit.models.Exercise;
import com.noroff.mefit.services.exercise.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final ModelMapper mapper;


    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
        mapper =new ModelMapper();
    }

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(exerciseService.findById(id));
    }

    @PostMapping()
    public ResponseEntity addNewExercise(@RequestBody ExercisePostDPO exercisePostDPO) throws URISyntaxException {
        Exercise exercise = mapper.map(exercisePostDPO, Exercise.class);
        exerciseService.add(exercise);
        int entity = exercise.getId();
        URI uri = new URI("exercise/" + entity);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateExercise(@RequestBody Exercise exercise, @PathVariable int id){
        exercise.setId(id);
        exerciseService.update(exercise);
        return ResponseEntity.noContent().build();
    }

}
