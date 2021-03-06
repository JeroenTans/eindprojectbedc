package com.example.eindprojectbedc.server.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_members")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String emailAddress;

    @Column
    private String groupName;

    @OneToMany(
            targetEntity = com.example.eindprojectbedc.server.model.User.class,
            mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<User> groupMembers = new HashSet<>();

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
