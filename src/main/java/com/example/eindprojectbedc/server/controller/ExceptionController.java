package com.example.eindprojectbedc.server.controller;

import com.example.eindprojectbedc.server.exception.BadRequestException;
import com.example.eindprojectbedc.server.exception.RecourceNotFoundException;
import com.example.eindprojectbedc.server.exception.UsernameNotFoundExeption;
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
