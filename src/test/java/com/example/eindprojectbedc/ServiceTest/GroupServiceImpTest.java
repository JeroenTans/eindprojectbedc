package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.Group;
import com.example.eindprojectbedc.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroupServiceImpTest {

    @Mock
    GroupRepository groupRepository;

    @InjectMocks
    private GroupServiceImp groupServiceImp;

    @BeforeEach
    public void setup() {
        groupServiceImp = new GroupServiceImp(groupRepository);
    }

    @Test
    public void testGetWholeGroup() {
        when(groupRepository.findAll()).thenReturn(List.of(new Group(), new Group()));
        List<Group> groupList = groupServiceImp.getWholeGroup();
        assertEquals(2, groupList.size());
    }

    @Test
    public void testSaveGroup() {
        Long id = 3L;
        Group testGroup = new Group();
        when(groupRepository.save(testGroup)).thenAnswer(inv -> {
            Group group1 = inv.getArgument(0);
            group1.setId(id);
            return group1;
        });
        Group created = groupServiceImp.saveGroup(testGroup);
        assertEquals(3L, created.getId());
    }

    @Test
    public void testDeleteGroup() {
        Group group = new Group();
        group.setId(1L);
        groupServiceImp.deleteGroup(group.getId());
        verify(groupRepository).deleteById(group.getId());
    }

    @Test
    public void testGetGroup() {
        Group group = new Group();
        group.setId(1L);
        Long id = group.getId();
        when(groupRepository.findById(id)).thenReturn(Optional.of(group));
        Optional<Group> groupOptional = Optional.ofNullable(groupServiceImp.getGroup(id));
        assertTrue(groupOptional.isPresent());
        assertEquals(id, groupOptional.get().getId());
    }
}
