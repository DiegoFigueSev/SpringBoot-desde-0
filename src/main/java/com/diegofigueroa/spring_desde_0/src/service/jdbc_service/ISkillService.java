package com.diegofigueroa.spring_desde_0.src.service.jdbc_service;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {
    Skill save(Optional<Skill> skill);
    Optional<Skill> getById(long id);
    List<Skill> getAll(Optional<Long> id);
    void delete(long id);
    Skill update(Skill skill);
}
