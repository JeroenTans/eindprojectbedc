package com.example.eindprojectbedc.controller.dto;

import com.example.eindprojectbedc.model.Group;

public class GroupInputDto {

    public String emailAddress;

    public Group toGroup() {
        var group = new Group();
        group.setEmailAddress(emailAddress);
        return group;
    }
}
