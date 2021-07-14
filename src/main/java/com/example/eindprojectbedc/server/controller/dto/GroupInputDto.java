package com.example.eindprojectbedc.server.controller.dto;

import com.example.eindprojectbedc.server.model.Group;

public class GroupInputDto {

    public String emailAddress;

    public Group toGroup() {
        var group = new Group();
        group.setEmailAddress(emailAddress);
        return group;
    }
}
