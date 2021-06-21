package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.exception.BadRequestException;
import com.example.eindprojectbedc.exception.RecourceNotFoundException;
import com.example.eindprojectbedc.exception.UsernameNotFoundExeption;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecourceNotFoundException.class)
    public ResponseEntity<Object> exception(RecourceNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> exception(BadRequestException exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(value = UsernameNotFoundExeption.class)
    public ResponseEntity<Object> exception(UsernameNotFoundExeption exception) {
        return ResponseEntity.badRequest().build();
    }
}
