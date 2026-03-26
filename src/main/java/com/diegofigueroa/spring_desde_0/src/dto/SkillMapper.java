package com.diegofigueroa.spring_desde_0.src.dto;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;

public class SkillMapper {
    //? Mapear es tranformar de un objeto a otro objeto

    public static SkillDto toDto(Skill skill){
        if (skill == null) return null;
        return new SkillDto(
                skill.getName(),
                skill.getLevel()
        );
    }

    public static Skill fromDto(SkillDto dto, Long id){
        if (dto == null) return null;
        return new Skill(
                id,
                dto.name(),
                dto.level(),
                1L
        );
    }
}
