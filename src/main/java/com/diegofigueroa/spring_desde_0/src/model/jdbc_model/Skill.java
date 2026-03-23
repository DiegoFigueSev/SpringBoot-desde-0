package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Skill {
    /*
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL ,
    level INT,
    CONSTRAINT fk_skill_personal_info
                    FOREIGN KEY (personal_info_id)
                    REFERENCES personal_info(id)
                    ON DELETE CASCADE
     */
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
}
