package com.noroff.mefit.services.goal;

import com.noroff.mefit.models.Goal;
import com.noroff.mefit.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    public GoalServiceImpl(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public Goal findById(Integer id) {
        return goalRepository.findById(id).get();
    }

    @Override
    public Collection<Goal> findAll() {
        return goalRepository.findAll();
    }

    @Override
    public Goal add(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public Goal update(Goal entity) {
        return goalRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        goalRepository.deleteById(id);
    }
}
