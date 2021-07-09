package com.example.eindprojectbedc.payload;


import com.example.eindprojectbedc.model.Authority;
import com.example.eindprojectbedc.model.User;

public class AuthenticationResponse {

    private String jwt;
    private String username;
    private String authorityRole;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, String username, String authorityRole) {
        this.jwt = jwt;
        this.username = username;
        this.authorityRole = authorityRole;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    public String getJwt() {
        return jwt;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthorityRole() {
        return authorityRole;
    }

    public void setAuthorityRole(String authorityRole) {
        this.authorityRole = authorityRole;
    }
}
