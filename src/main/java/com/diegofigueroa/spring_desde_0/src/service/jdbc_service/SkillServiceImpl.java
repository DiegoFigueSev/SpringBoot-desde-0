package com.diegofigueroa.spring_desde_0.src.service.jdbc_service;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService{

    private final ISkillRepository repository;

    @Override
    public Skill save(Optional<Skill> skill) {
        return repository.save(skill);
    }

    @Override
    public Optional<Skill> getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Skill> getAll(Optional<Long> id) {
        return repository.getAll(id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Skill update(Skill skill) {
        return repository.update(skill);
    }
}
