package com.diegofigueroa.spring_desde_0.src.service.jdbc_service;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;

import java.util.List;
import java.util.Optional;

public interface IPersonalInfoService {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(long id);
    List<PersonalInfo> findAll();
    void deleteById(Long id);
}
