package com.example.eindprojectbedc.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "group_members")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String emailAddress;
    
    private String groupName;


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
