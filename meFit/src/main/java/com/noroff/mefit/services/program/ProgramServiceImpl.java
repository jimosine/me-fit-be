package com.noroff.mefit.services.program;

import com.noroff.mefit.models.Program;
import com.noroff.mefit.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProgramServiceImpl implements ProgramService{

    private final ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program findById(Integer id) {
        return programRepository.findById(id).get();
    }

    @Override
    public Collection<Program> findAll() {
        return programRepository.findAll();
    }

    @Override
    public Program add(Program entity) {
        return programRepository.save(entity);
    }

    @Override
    public Program update(Program entity) {
        return programRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        programRepository.deleteById(id);
    }
}
