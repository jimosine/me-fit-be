package com.noroff.mefit.controllers;

import com.noroff.mefit.models.DTO.program.ProgramPostDTO;
import com.noroff.mefit.models.Program;
import com.noroff.mefit.services.program.ProgramService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/program")
public class ProgramController {
    private final ProgramService programService;
    private final ModelMapper mapper;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
        mapper =new ModelMapper();
    }

    @GetMapping()
    public ResponseEntity findAll(){

        return ResponseEntity.ok(programService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(programService.findById(id));
    }

    @PostMapping
    public ResponseEntity addNewProgram(@RequestBody ProgramPostDTO programPostDTO) throws URISyntaxException {
        Program program = mapper.map(programPostDTO, Program.class);
        programService.add(program);
        int entity = program.getId();
        URI uri = new URI("program/" + entity);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateGoal(@RequestBody Program program, @PathVariable int id) {
        program.setId(id);
        programService.update(program);
        return ResponseEntity.noContent().build();
    }


}
