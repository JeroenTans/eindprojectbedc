package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.RecourceNotFoundException;
import com.example.eindprojectbedc.model.Group;
import com.example.eindprojectbedc.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GroupServer {

    @Autowired
    private GroupRepository groupRepository;

    public Collection<Group> getGroup() {
        return groupRepository.findAll();
    }

    public Group createGroup (@RequestBody Group group){
        return groupRepository.save(group);
    }

    public Map<String, Boolean> deleteGroupMember(@PathVariable Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new RecourceNotFoundException("Groep member bestaat niet onder id: " + id));

        groupRepository.delete(group);
        Map<String, Boolean> response = new HashMap<>();
        response.put("verwijderd", Boolean.TRUE);
        return (Map<String, Boolean>) ResponseEntity.ok(response);
    }
}
