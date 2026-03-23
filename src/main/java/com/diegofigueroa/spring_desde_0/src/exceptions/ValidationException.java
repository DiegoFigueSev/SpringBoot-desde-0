package com.diegofigueroa.spring_desde_0.src.exceptions;

import lombok.Getter;
import org.springframework.validation.BindingResult;

@Getter
public class ValidationException extends RuntimeException {

    private BindingResult bindingResult;

    public ValidationException(BindingResult bindingResult) {
        super("Errore de validacion: Se encontraron " + bindingResult.getErrorCount());
        this.bindingResult = bindingResult;
    }
}
