package com.example.eindprojectbedc.Service;

import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Group;
import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.repository.GroupRepository;
import com.example.eindprojectbedc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImp implements GroupService{

    private GroupRepository groupRepository;

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public GroupServiceImp(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getWholeGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroup(Long id) {
        var optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return optionalGroup.get();
        } else throw new NotFoundException();
    }

    @Override
    public Group saveGroup(Group group) {
        String username = group.getEmailAddress();
        User user = userRepository.getById(username);
        user.setGroupName(group.getGroupName());
        return groupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
