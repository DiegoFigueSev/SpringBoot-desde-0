package com.diegofigueroa.spring_desde_0.src.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;

public record SkillDto(

        @NotBlank
        @Size(max = 40)
        String name,

        @Positive
        @Max(value = 5)
        Integer level

) {}

/*
private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 10, max = 40, message = "El nombre es muy corto o largo")
    private String name;

    @Positive(message = "El numero no puede ser menor a 0")
    @Max(value = 5, message = "El numero como maximo puede ser 5")
    @NotNull(message = "El level es obligatorio")
    private Integer level;

    @Positive(message = "Personal id invalido")
    private Long personalInfoId;
 */