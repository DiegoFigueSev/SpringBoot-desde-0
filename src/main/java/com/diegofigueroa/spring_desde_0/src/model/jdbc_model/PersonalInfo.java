package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    //* Forma declarativa - ventajas - mayor limpieza
    //? Una forma imperativa, seria el hacerlo totalmente en codigo mediante sentencias
    @NotBlank(message = "El id no puede estar vacio") //* Validacion : Garantiza que no sea nulo ni vacio
    @Size(min = 5, max = 100, message = "El nombre debe ser mas largo o mas corto")
    private String firstName;

    private String lastName;

    private String title;

    private String profileDescription;

    @Email(message = "Email no es valido")
    private String email;
}

/**
 * JPA tiene su convencion
 * para la base de datos usar: _ y em plural
 * para las entidades KebabCase y en singular
 */

/**
 *
 * Es una excelente práctica (y casi un requisito para automatizaciones de frameworks)
 * utilizar convenciones como singular/PascalCase en entidades Java
 * y plural/minúsculas/snake_case en las tablas SQL.
 */