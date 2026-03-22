package com.diegofigueroa.spring_desde_0.src.controler.theme_00_Introduction;

import com.diegofigueroa.spring_desde_0.src.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//* REST controller lo usamos cuando tengamos un servicio que sera consumido por React, Angular, etc
@RestController //? Rest CREA servicios - Controller para pagina web
@RequestMapping("/api")
public class MyRestController {

    @GetMapping("/default")
    public Person getPerson(){
        return new Person(
                "Diego",
                "Figueroa",
                Optional.of((byte) 23)
        );
    }
}
