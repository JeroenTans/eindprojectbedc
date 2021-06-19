package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.GroupService;
import com.example.eindprojectbedc.controller.dto.GroupDto;
import com.example.eindprojectbedc.controller.dto.GroupInputDto;
import com.example.eindprojectbedc.model.Group;
import com.example.eindprojectbedc.model.TipAmsterdam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


//    public TipAmsterdam getTipAmsterdam(@PathVariable("id") Long id) {
//        return tipAmsterdamService.getTipAmsterdam(id);
//    }
    @GetMapping("/{id}")
    public Group getGroupMember(@PathVariable("id") Long id) {
        return groupService.getGroup(id);
    }

    @PostMapping
    public GroupDto saveGroup(@RequestBody GroupInputDto dto) {
        var group = groupService.saveGroup(dto.toGroup());
        return GroupDto.fromGroup(group);
    }

}
//    public List<GroupDto> getWholeGroup() {
//        var dtos = new ArrayList<GroupDto>();
//        var wholeGroup = groupService.getWholeGroup();
//
//        for (Group group : wholeGroup) {
//            dtos.add(GroupDto.fromGroup(group));
//        }
//        return dtos;
//    }