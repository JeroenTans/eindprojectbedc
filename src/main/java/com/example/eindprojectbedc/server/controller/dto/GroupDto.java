package com.example.eindprojectbedc.server.controller.dto;

import com.example.eindprojectbedc.server.model.Group;

public class GroupDto {

    private long id;

    private String emailAddress;

    public static GroupDto fromGroup (Group group) {
        var dto = new GroupDto();
        dto.id = group.getId();
        dto.emailAddress = group.getEmailAddress();
        return dto;
    }

}
