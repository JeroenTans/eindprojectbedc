package com.example.eindprojectbedc.exception;

public class UsernameNotFoundExeption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public String UsernameNotFoundException(String username) {
        return "Cannot find user " + username;
    }
}
