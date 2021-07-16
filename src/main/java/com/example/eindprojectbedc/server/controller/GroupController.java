package com.example.eindprojectbedc.server.controller;

import com.example.eindprojectbedc.server.Service.GroupService;
import com.example.eindprojectbedc.server.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getWholeGroup() {
        return groupService.getWholeGroup();
    }

    @GetMapping("/{id}")
    public Group getGroupMember(@PathVariable("id") Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping
    public Group saveGroup(@RequestBody Group groupOne) {
        var group = groupService.saveGroup(groupOne);
        return group;
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void deleteGroupMemberById (@PathVariable Long id) {
        groupService.deleteGroup(id);
    }

}
