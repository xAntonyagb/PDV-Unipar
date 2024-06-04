package org.example.pdvapi.controllers;

import org.example.pdvapi.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    //Outras exceções
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiException handleException(Exception e) {
        return new ApiException(e.getMessage());
    }

    //Validation Bean
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiException handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getField() + ": " +
                    fieldError.getDefaultMessage());
        }

        ApiException apiException = new ApiException(errors);

        return apiException;
    }
}

