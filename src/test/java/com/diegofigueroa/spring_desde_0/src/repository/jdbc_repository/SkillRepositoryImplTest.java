package com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository;

import com.diegofigueroa.spring_desde_0.src.exceptions.ValidationException;
import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;
import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
//? Mockito es un framework de pruebas unitarias
@ExtendWith(MockitoExtension.class) //? Un mock es un objeto falso que simula a uno real
class SkillRepositoryImplTest {

    @Mock
    private ISkillRepository repository;

    @Test
    void testSavedValidProduct() {
        //* Las etapas de un test son: preparacion - accion - verificacion
        //Arrange : Preparacion
        var validSkill = new Skill(
                null,
                "Diego",
                3,
                1l
        );
        var responseSkill = new Skill(
                1L,
                validSkill.getName(),
                validSkill.getLevel(),
                validSkill.getPersonalInfoId()
        );
        when(repository.save(Optional.of(validSkill))).thenReturn(responseSkill); //? SIMULAMOS LA FUNCIONALIDAD

        //Action : Accion
        var skill = Optional.ofNullable(repository.save(Optional.of(validSkill)));

        //Asser - Verificacion
        assertTrue(skill.isPresent());
        assertEquals(responseSkill, skill.get());
        verify(repository, times(1)).save(Optional.of(validSkill));
    }

    @Test
    void testFindByIdReturnNullWhenNotFound(){
        //Arrange
        var invalidID = 444L;
        when(repository.getById(invalidID)).thenReturn(Optional.empty());

        //Action
        var response = repository.getById(invalidID);

        //Asser
        assertTrue(response.isEmpty());
        verify(repository, times(1)).getById(invalidID);
    }

    @Test
    void testSavedInvalidProduct() {
        //* Las etapas de un test son: preparacion - accion - verificacion
        //Arrange : Preparacion
        var invalidSkill = new Skill(
                null,
                "",
                3,
                1l
        );

        //Asser - Verificacion
        //assertThrows(ValidationException.class, () -> repository.save(Optional.of(invalidSkill)), "El producto se guardo cuando deberia lanzar una excepcion");

        verify(repository, never()).save(Optional.of(invalidSkill));
    }
}