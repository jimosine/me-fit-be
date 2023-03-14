package com.noroff.mefit.controllers;

import com.noroff.mefit.models.DTO.goal.GoalPostDTO;
import com.noroff.mefit.models.Goal;
import com.noroff.mefit.services.goal.GoalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/goal")
public class GoalController {
    private final GoalService goalService;
    private final ModelMapper mapper;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
        mapper =new ModelMapper();
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(goalService.findAll()) ;
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(goalService.findById(id));
    }

    @PostMapping()
    public ResponseEntity addNewGoal (@RequestBody GoalPostDTO goalPostDTO) throws URISyntaxException {
        Goal goal = mapper.map(goalPostDTO, Goal.class);
        goalService.add(goal);
        int entity = goal.getId();
        URI uri = new URI("goal/" + entity);
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("{id}")
    public ResponseEntity updateGoal(@RequestBody Goal goal, @PathVariable int id) {
        goal.setId(id);
        goalService.update(goal);
        return ResponseEntity.noContent().build();
    }





}
