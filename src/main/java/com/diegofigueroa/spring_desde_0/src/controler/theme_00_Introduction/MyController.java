package com.diegofigueroa.spring_desde_0.src.controler.theme_00_Introduction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//? Cuando marcamos una clase y la decoramos con CONTROLLER
//? Springboot autoconfigura automacitamente la clase para que este atento a peticiones http
@Controller //* Controller se usa cuando vamos a usarlo unicamente en este proyecto, creamos paginas desde aqui
@RequestMapping("/doc") //? Request Mapping nos ayuda a crear UNA RUTA BASE
public class MyController {

    //* CADA PETICION QUE LLEVA, UTILIZA UN HILO, PARA EVITAR Q EL PROGRAMA SE BLOQUEE
    @GetMapping("/spring-boot")
    public String springVersions(){
        return "spring-boot";
    }

    //* Podemos definir varias rutas q retornaran un mismo resultado
    @GetMapping({"/spring", "info"}) //? Definimos que al ir a spring e info nos mostrara lo mismo
    public String spring(){
        return "spring-boot";
    }

    @RequestMapping(value = "/otherwise", method = RequestMethod.GET)
    public String requestMapping(){
        return "spring-boot";
    }
}
