package com.example.eindprojectbedc.server.payload;


public class AuthenticationResponse {

    private String jwt;
    private String username;
    private String authorityRole;
    private String groupName;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, String username, String authorityRole, String groupName) {
        this.jwt = jwt;
        this.username = username;
        this.authorityRole = authorityRole;
        this.groupName = groupName;
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
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
