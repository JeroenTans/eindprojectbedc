package com.example.eindprojectbedc.exception;

public class IdNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IdNotFoundException (Long id) { super("kan de tip met het id: " + id + "niet vinden");}
}
