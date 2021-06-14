package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.GroupServer;
import com.example.eindprojectbedc.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/group_members")
public class GroupController {

    @Autowired
    private GroupServer groupServer;

    @GetMapping("/get_group_members")
    public ResponseEntity<Object>getGroupMembers(){
        return ResponseEntity.ok().body(groupServer.getGroup());
    }

    @PostMapping("/post_group_members")
    public ResponseEntity<Group> createGroup(@RequestBody Group group){
        return ResponseEntity.ok().body(groupServer.createGroup(group));
    }

    @DeleteMapping("/delete_group_members/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteGroupMember(@PathVariable Long id){
        return ResponseEntity.ok(groupServer.deleteGroupMember(id));
    }

}
