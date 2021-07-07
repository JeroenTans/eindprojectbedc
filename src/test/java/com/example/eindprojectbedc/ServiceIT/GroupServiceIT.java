package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.GroupServiceImp;
import com.example.eindprojectbedc.model.Group;
import com.example.eindprojectbedc.repository.GroupRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class GroupServiceIT {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupServiceImp groupServiceImp;

    @BeforeEach
    public void deleteAll(){
        groupRepository.deleteAll();
    }

    @Test
    public void itSaveGroup(){
        Group group = new Group();
        group.setId(1L);
        group.setEmailAddress("jer@");
        groupRepository.save(group);
        List<Group> groupList = groupServiceImp.getWholeGroup();
        assertEquals(1, groupList.size());
    }

    @Test
    public void itGetWholeGroup(){
        Group group = new Group();
        group.setEmailAddress("jer@");
        group.setId(1L);
        groupRepository.save(group);
        List<Group> groupList = groupServiceImp.getWholeGroup();
        assertEquals(1, groupList.size());
    }

//    @Test
//    public void itDeleteGroupById(){
//        Group group = new Group();
//        group.setEmailAddress("jer@");
//        group.setId(1L);
//        groupRepository.save(group);
//        List<Group> groupList = groupServiceImp.getWholeGroup();
//        groupRepository.deleteById(group.getId());
//        List<Group> groupList2 = groupServiceImp.getWholeGroup();
//        assertEquals(0, groupList2.size());
//    }

//    @Test
//    public void itGetGroupById(){
//        Group group = new Group();
//        group.setEmailAddress("jer@");
//        group.setId(1L);
//        Group created = groupRepository.save(group);
//        Optional<Group> fround = Optional.ofNullable(groupServiceImp.getGroup(group.getId()));
//        assertTrue(fround.isPresent());
//        assertEquals(created, fround.get());
//    }

}
