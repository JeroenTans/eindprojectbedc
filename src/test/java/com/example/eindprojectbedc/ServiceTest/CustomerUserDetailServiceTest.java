package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerUserDetailServiceTest {

    @Mock
    UserService userService;

    @Mock
    CustomUserDetailsService customUserDetailsService;

//    @Test
//    public void loadUserByUsername(){
//        User testUser = new User();
//        testUser.setUsername("jan");
//        testUser.setPassword("jannie");
//        when(userService.getUser(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
//        customUserDetailsService.loadUserByUsername(testUser.getUsername());
//        assertEquals(testUser.getUsername(),customUserDetailsService.loadUserByUsername(testUser.getUsername()).getUsername());
//        assertEquals(testUser.getPassword(),customUserDetailsService.loadUserByUsername(testUser.getUsername()).getPassword());
//    }
}
//
//    @Test
//    void loadUserByUsername() {
//        User testUser = new User("testUsername","testPassword","testEmail","testPhoto","testBirthDate","testFirstName",
//                "testLastName","testAbout","testLocation","testGender");
//        when(userService.getUser(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
//        customUserDetailsService.loadUserByUsername(testUser.getUsername());
//        assertEquals(testUser.getUsername(),customUserDetailsService.loadUserByUsername(testUser.getUsername()).getUsername());
//        assertEquals(testUser.getPassword(),customUserDetailsService.loadUserByUsername(testUser.getUsername()).getPassword());
//    }
