package com.noroff.mefit.controllers;

import com.noroff.mefit.models.DTO.goal.*;
import com.noroff.mefit.models.Goal;
import com.noroff.mefit.models.Profile;
import com.noroff.mefit.models.Program;
import com.noroff.mefit.services.goal.GoalService;
import com.noroff.mefit.services.profile.ProfileService;
import com.noroff.mefit.services.program.ProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/goal")
public class GoalController {
    private final GoalService goalService;
    private final ProfileService profileService;
    private final ProgramService programService;
    private final ModelMapper mapper;

    public GoalController(GoalService goalService, ProfileService profileService, ProgramService programService) {
        this.goalService = goalService;
        this.profileService = profileService;
        this.programService = programService;

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
        Profile profile = profileService.findById(goalPostDTO.getProfileId());
        Goal goal = mapper.map(goalPostDTO, Goal.class);
        goal.setProfile(profile);
        Goal saveGoal = goalService.add(goal);
        URI uri = new URI("goal/" + saveGoal.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateGoal(@RequestBody Goal goal, @PathVariable int id) {
        goal.setId(id);
        goalService.update(goal);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/addProgram")
    public ResponseEntity addProgramToGoal(@PathVariable int id, @RequestBody AddProgramToGoalDTO addProgramToGoalDTO){
        Goal goal = goalService.findById(id);
        Set<Program> programList = new HashSet<>();
        if (!goal.getWorkouts().isEmpty()){
            throw new RuntimeException("There is already a workout");
        }else {
            for (Integer programId : addProgramToGoalDTO.getProgramIds()){
                Program program = programService.findById(programId);
                programList.add(program);
            }
            goal.setPrograms(programList);
            goalService.update(goal);
        }
        return ResponseEntity.noContent().build();
    }






}
