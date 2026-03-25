package com.diegofigueroa.spring_desde_0.src.service.jdbc_service;

import com.diegofigueroa.spring_desde_0.src.exceptions.ValidationException;
import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService{

    private final ISkillRepository repository;
    private final Validator validator;

    @Override
    @Transactional()
    public Skill save(Optional<Skill> skill) {

        var realSkill = skill.orElseThrow(() -> new IllegalArgumentException("El argumento skill no puede estar vacio"));

        BindingResult bindingResult = new BeanPropertyBindingResult(realSkill, "skill");

        validator.validate(skill.get(), bindingResult);
        if (bindingResult.hasErrors()){
            throw new ValidationException(bindingResult);
        }
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
