package com.diegofigueroa.spring_desde_0.service;

import com.diegofigueroa.spring_desde_0.src.exceptions.ValidationException;
import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;
import com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository.IPersonalInfoRepository;
import com.diegofigueroa.spring_desde_0.src.service.jdbc_service.IPersonalInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PersonalInfoTest {

    @Autowired
    private IPersonalInfoRepository repository;

    @Autowired
    private IPersonalInfoService service;

    @Test
    void testValidCreatePersonalInfo(){
        var validPersonalInfo = new PersonalInfo(
                null,
                "Diego",
                "Figueroa",
                "Ing desarrollo",
                "Analista de automatizacion",
                "diego@gmail.com"
        );
        var response = service.save(validPersonalInfo);
        assertNotNull(response.getId(), "El servicio no creo correctamente al usuario");
        assertNotNull(repository.findById(response.getId()), "El usuario no se agrego correctamente a la base de datos");
    }

    @Test
    void testInvalidCreatePersonalInfo(){
        var invalidPersonalInfo = new PersonalInfo(
                null,
                "",
                "Figueroa",
                "Ing desarrollo",
                "Analista de automatizacion",
                "diego@gmail.com"
        );

        assertThrows(ValidationException.class, () -> service.save(invalidPersonalInfo), "No se disparo los errores al verificar los atributos del tipo de datos");
    }


}
