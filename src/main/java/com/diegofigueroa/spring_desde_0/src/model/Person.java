package com.diegofigueroa.spring_desde_0.src.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Person {
    private String firstName;
    @NonNull
    private String lastName;
    private Optional<Byte> age;
}
