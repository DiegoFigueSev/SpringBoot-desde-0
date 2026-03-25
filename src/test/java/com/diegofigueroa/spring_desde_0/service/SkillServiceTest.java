package com.diegofigueroa.spring_desde_0.service;

import com.diegofigueroa.spring_desde_0.src.exceptions.ValidationException;
import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository.ISkillRepository;
import com.diegofigueroa.spring_desde_0.src.service.jdbc_service.ISkillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //? Definimos la clase test
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) //? Cada vez q realizo una prueba, vuelve la db al estado inicial
public class SkillServiceTest {

    @Autowired //? Inyecta la dependencia
    private ISkillService service;

    @Autowired //? Inyecta la dependencia
    private ISkillRepository repository;

    /**
     * Porque ahora usamos @Autowired?
     *
     * Porque lo que espera springboot test es un constructor vacio, no espera que inyectemos
     * las dependencias DENTRO del constructor
     *
     * A diferencia que usar lombok sin autowired dentro de otras carpetas no testing
     * ahi si esperamos inyectar las dependencias al inicializar la clase. Es por eso que matche
     * e inyecta y por eso podeos usar lombok
     *
     * En este caso no, debemos de aplicar el autowired sin atributos final
     */

    @Test
    void testSaveValidSkill(){
        Skill validSkill = new Skill(null, "Javascript", 4, 1L);
        Skill savedSkill = service.save(Optional.of(validSkill));

        assertNotNull(savedSkill.getId(), "El objeto guardado debe tener un ID asignado");
        assertNotNull(repository.getById(savedSkill.getId()).orElse(null), "El objeto guardado debe existir en la base de datos");
    }

    @Test
    void textSaveInvalidSkill(){
        Skill invalidSkill = new Skill(null, "", 4, 1L);

        assertThrows(
                ValidationException.class,
                () -> service.save(Optional.of(invalidSkill)),
                "Debe lanzarse un ValidationException cuando el nombre de la Skill esta vacio"
        );


    }
}
