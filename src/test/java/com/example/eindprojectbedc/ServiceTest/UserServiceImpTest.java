package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userServiceImp;

    @Test
    public void testGetAllUsers(){
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        Collection<User> userList = userServiceImp.getUsers();
        assertEquals(2, userList.size());
    }

//    @Test
//    public void testGetUser(){
//        User user = new User();
//        user.setUsername("Jan");
//        String username = user.getUsername();
//        when(userRepository.findById(username)).thenReturn(Optional.of(user));
//        Optional<User> userOptional = Optional.ofNullable(userServiceImp.getUser(user.getUsername()))
//
//
//        assertTrue(userOptional.isPresent());
//        assertEquals(username, userOptional.);
//    }

    @Test
    public void deleteUser(){
        User user = new User();
        user.setUsername("jan");
        userServiceImp.deleteUser(user.getUsername());
        verify(userRepository).deleteById(user.getUsername());
    }

}