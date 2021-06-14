package com.example.eindprojectbedc.controller.dto;

import com.example.eindprojectbedc.model.Group;

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
