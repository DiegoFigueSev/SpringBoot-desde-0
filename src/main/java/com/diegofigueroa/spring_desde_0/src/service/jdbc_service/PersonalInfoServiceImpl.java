package com.diegofigueroa.spring_desde_0.src.service.jdbc_service;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;
import com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository.IPersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//* Q hace un service?
//* La capa de servicio se encarga de la LOGICA DE NEGOCIO REAL DE LA APLICACION
//? Le dice a sprign que hay una clase  que se encarga de la logica de negocio
//? por ej: coordinar operaciones - procesar informacion
//? manejar fechas - validar datos - etc
@RequiredArgsConstructor
@Service
public class PersonalInfoServiceImpl implements IPersonalInfoService{

    private final IPersonalInfoRepository repository;

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {

        return repository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<PersonalInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
