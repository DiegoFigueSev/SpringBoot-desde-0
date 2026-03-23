package com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillRepository {
    Skill save(Optional<Skill> skill);
    Optional<Skill> getById(long id);
    List<Skill> getAll(Optional<Long> id);
    void delete(long id);
    Skill update(Skill skill);
}

