package com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoRepository {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);
}
