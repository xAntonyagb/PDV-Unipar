package org.example.pdvapi.controllers;

import org.example.pdvapi.exceptions.ApiExceptionDTO;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
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
    public ApiExceptionDTO handleException(Exception e) {
        ApiExceptionDTO apiException = new ApiExceptionDTO(e.getMessage());
        return apiException;
    }
    //Exceção de Validação
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiExceptionDTO handleIllegalArgumentException(ValidationException e) {
        ApiExceptionDTO apiException = new ApiExceptionDTO(e.getMessage());
        return apiException;
    }

    //Exeção de No Data Found
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiExceptionDTO handleApiException(NotFoundException e) {
        ApiExceptionDTO apiException = new ApiExceptionDTO(e.getMessage());
        return apiException;
    }

    //Validation Bean
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiExceptionDTO handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        List<String> errors = new ArrayList<>();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.add(fieldError.getField() + ": " +
                    fieldError.getDefaultMessage());
        }

        ApiExceptionDTO apiException = new ApiExceptionDTO(errors);

        return apiException;
    }
}

