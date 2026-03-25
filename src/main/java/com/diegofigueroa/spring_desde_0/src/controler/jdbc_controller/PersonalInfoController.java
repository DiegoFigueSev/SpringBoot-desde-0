package com.diegofigueroa.spring_desde_0.src.controler.jdbc_controller;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;
import com.diegofigueroa.spring_desde_0.src.service.jdbc_service.IPersonalInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController //? RETORNA UNA RESPUESTA - OBJETO JSON, ETC SIEMPRE RETORNA ALGO
@RequestMapping("/persona-info") //? DEFINIMOS LA RUTA BASE
public class PersonalInfoController {

    //* PORQUE USAMOS LA INTERFACE?
    //? USAMOS LA INTERFACE PARA RESPETAR EL PRINCPIO SOLID DE:
    //* DEPENDENCI INVERSION
    //* DEPENDEMOS DE ABSTRACCIONES Y NO DE CLASES CONCRETAS
    private final IPersonalInfoService service;

    //* GET NOS RETORNA ALGO (sin modificar la db solo consultamos por info)
    @GetMapping
    public List<PersonalInfo> getAll(){
        return service.findAll();
    }

    //* DELETE elimina algo del a db
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ //* Path variable se usa para varaibles OBLIGATORIAS que estaran en la ruta
        service.deleteById(id);
    }

    //* POST agrega informacion en la db
    @PostMapping
    public ResponseEntity<PersonalInfo> create(@RequestBody PersonalInfo info){ //? Un request body es el CUERPO de la peticion, este cuerpo es un JSON
        var person = service.save(info);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    //? Usamos ResponseEntity para controlar la respuesta http

    //* PATH acualiza/modifia un recurso parcialmente
    @PatchMapping()
    public PersonalInfo update(@RequestBody PersonalInfo info){
        return service.save(info);
    }

    @GetMapping("/{id}")
    public PersonalInfo getById(@PathVariable Long id){
        var info = service.findById(id);
        if (info.isPresent()) return info.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento no encontrado");
    }
}
