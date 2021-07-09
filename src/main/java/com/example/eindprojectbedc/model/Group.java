package com.example.eindprojectbedc.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_members")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String emailAddress;
    
    private String groupName;

    @OneToMany(
            targetEntity = com.example.eindprojectbedc.model.User.class,
            mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<User> groupMembers = new HashSet<>();

//    @OneToMany(
//            targetEntity = com.example.eindprojectbedc.model.TipAmsterdam.class,
//            mappedBy = "username",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private Set<User> groupTipAmsterdams = new HashSet<>();

//    @OneToMany(
//            targetEntity = com.example.eindprojectbedc.model.TipAmsterdam.class,
//            mappedBy = "username",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private Set<TipAmsterdam> tipAmsterdams = new HashSet<>();

    public Group() {
    }

    public Group(String emailAddress, String groupName) {
        this.emailAddress = emailAddress;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
