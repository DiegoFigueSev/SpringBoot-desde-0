package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class PersonalInfo {
    /*
        id SERIAL PRIMARY KEY,
        first_name VARCHAR(100) NOT NULL,
        last_name VARCHAR(100) NOT NULL ,
        title VARCHAR(255) NOT NULL ,
        profile_description TEXT NOT NULL
         */
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String profileDescription;
}

/**
 * JPA tiene su convencion
 * para la base de datos usar: _ y em plural
 * para las entidades KebabCase y en singular
 */