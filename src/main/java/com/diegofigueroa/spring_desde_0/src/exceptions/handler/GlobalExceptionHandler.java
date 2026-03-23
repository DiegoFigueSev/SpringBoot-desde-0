package com.diegofigueroa.spring_desde_0.src.exceptions.handler;

import com.diegofigueroa.spring_desde_0.src.exceptions.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//* Que es controller advice??
//* Es un decorator de clase
//* Le decimos a SPRING que esta clase definira reglas para TODOS los controladores
//* reglas para el manejo de excepciones
//? Centralizamos la logica de manejo de errores en un solo lugar, en vez de tner try catch por todo lado
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class) //? Un exception handler, es una funcion atenta al error Y AL TIPO DE ERROR
    public ResponseEntity<?> handleValidationException(ValidationException ex){
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors().stream()
                .map(e -> e.getDefaultMessage()).toList());
    }
    @ExceptionHandler(IllegalArgumentException.class) //? Un exception handler, es una funcion atenta al error Y AL TIPO DE ERROR
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
