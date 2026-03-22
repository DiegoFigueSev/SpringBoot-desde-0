package com.diegofigueroa.spring_desde_0.src.controler.theme_00_Introduction;

import com.diegofigueroa.spring_desde_0.src.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final List<Person> cacheList = new ArrayList<>();

    //Basic Get
    //? Un GET es metodo HTTP donde nosotros ENVIAMOS informacion al cliente
    //* Se usa para:
    //
    //*   consultar información
    //*   no modificar nada
    @GetMapping("default")
    public Person getDefault(){
        var defaultPerson = new Person("Diego Hernan", "Figueroa Sevillano", Optional.of((byte) 24));
        return defaultPerson;
    }

    //Get all
    @GetMapping
    public List<Person> getPersons(){
        return cacheList;
    }


    //? Un POST es un metodo http donde nosotros PEDIMOS informacion del cliente para realizar alguna accion
    //* Se usa para:
    //
    //*    crear recursos
    @PostMapping
    public Person addPerson(@RequestBody Person person){
        var auxPerson = new Person(
                person.getFirstName(),
                person.getLastName(),
                person.getAge()
        );
        cacheList.add(auxPerson);
        return auxPerson;
    }


    //* Request Params
    //? Son parametros en la request
    //? Esta anotacion nos permite obtener valores enviamos como parametros en la URL
    //? Los requestp params funcionan en get y posts
    @GetMapping("/filter")
    public List<Person> showAge(@RequestParam(defaultValue = "", required = false) int filter){
        var filterList = cacheList.stream()
                .filter(e -> e.getAge().isPresent())
                .filter(e -> e.getAge().get() >= (byte)filter)
                .toList();
        return filterList;
    }
    //* Un request param se usa para filtrar datos o agregar ciertas opciones

    //* Path Variable
    //? El request param ES parte de la ruta, es OBLIGATORIO
    @GetMapping("/{id}/{name}")
    public Person getPersonByName(@PathVariable String name, @PathVariable int id){
        if (id > cacheList.size()) return null;
        var filterPerson = cacheList.get(id-1);
        var person = Optional.ofNullable(filterPerson)
                .filter(e -> e.getFirstName().equalsIgnoreCase(name))
                .orElse(null);
        return person;
    }
    //* Se lo usa para identificar un recurso en especifico
}