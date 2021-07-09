package com.example.eindprojectbedc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String apikey;

    @Column
    private String email;

    @Column
    private String residence;

    private String groupName;

    private String authority;

    @OneToMany(
            targetEntity = com.example.eindprojectbedc.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    @OneToMany(
            targetEntity = com.example.eindprojectbedc.model.TipAmsterdam.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<TipAmsterdam> tipAmsterdams = new HashSet<>();

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public Set<TipAmsterdam> getTipAmsterdams() {
        return tipAmsterdams;
    }
    public void setTipAmsterdams(Set<TipAmsterdam> tipAmsterdams) {
        this.tipAmsterdams = tipAmsterdams;
    }
    public String getResidence() {
        return residence;
    }
    public void setResidence(String residence) {
        this.residence = residence;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEnabled() { return enabled;}
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public String getApikey() { return apikey; }
    public void setApikey(String apikey) { this.apikey = apikey; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}
    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }
}
