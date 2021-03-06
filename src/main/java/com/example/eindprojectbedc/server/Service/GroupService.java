package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getWholeGroup();
    Group getGroup(Long id);
    Group saveGroup(Group group);
    void deleteGroup(Long id);

}
