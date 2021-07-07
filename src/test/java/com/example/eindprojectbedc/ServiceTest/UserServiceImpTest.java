package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Authority;
import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpTest.class);

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImp userServiceImp;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        Collection<User> userList = userServiceImp.getUsers();
        assertEquals(2, userList.size());
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setUsername("jan");
        userServiceImp.deleteUser(user.getUsername());
        verify(userRepository).deleteById(user.getUsername());
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setUsername("jan");
        String username = user.getUsername();
        when(userRepository.findById(username)).thenReturn(Optional.of(user));
        Optional<User> userOptional = userServiceImp.getUser(username);
        assertTrue(userOptional.isPresent());
        assertEquals(username, userOptional.get().getUsername());
    }

    @Test
    public void testUserExists() {
        User user = new User();
        user.setUsername("jan");
        String username = user.getUsername();
        when(userRepository.existsById(username)).thenReturn(true);
        assertTrue(userRepository.existsById(username));
    }

    @Test
    public void testUpdateUser() {
        User initialUser = new User();
        initialUser.setUsername("jan");
        initialUser.setPassword("jannie");
        User update = new User();
        update.setUsername("joep");
        update.setPassword("joepie");
        when(userRepository.existsById(update.getUsername())).thenReturn(true);
        when(userRepository.findById(update.getUsername())).thenReturn(Optional.of(initialUser));
        userServiceImp.updateUser(update.getUsername(), update);
        verify(userRepository).save(userCaptor.capture());
        User savedUser = userCaptor.getValue();
        assertThat(savedUser.getPassword().equals(update.getPassword()));
    }

    @Test
    public void testCreateUser() {
        User initialUser = new User();
        initialUser.setUsername("jan");
        initialUser.setPassword(passwordEncoder.encode("jannie"));
        String passwordForm = passwordEncoder.encode(initialUser.getPassword());
        when(userRepository.save(initialUser)).thenReturn(initialUser);
        userServiceImp.createUser(initialUser);
        verify(userRepository).save(userCaptor.capture());
        User newUser = userCaptor.getValue();
        assertThat(initialUser.getUsername().equals(newUser.getUsername()));
    }

    @Test
    public void testGetAuthorities() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        testUser.addAuthority(new Authority(testUser.getUsername(), "ADMIN"));
        when(userRepository.existsById(testUser.getUsername())).thenReturn(true);
        when(userRepository.findById(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
        assertEquals(testUser.getAuthorities(), userServiceImp.getAuthorities(testUser.getUsername()));
    }

    @Test
    public void testAddAuthority() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(true);
        when(userRepository.findById(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
        userServiceImp.addAuthority(testUser.getUsername(), "ADMIN");
        verify(userRepository).save(testUser);
    }

    @Test
    public void testRemoveAuthority() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        testUser.addAuthority(new Authority(testUser.getUsername(), "ADMIN"));
        when(userRepository.existsById(testUser.getUsername())).thenReturn(true);
        when(userRepository.findById(testUser.getUsername())).thenReturn(java.util.Optional.of(testUser));
        userServiceImp.removeAuthority(testUser.getUsername(), "ADMIN");
        verify(userRepository).save(testUser);
    }

    @Test
    public void testRemoveAuthority2() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(false);
        assertThrows(UsernameNotFoundException.class, () -> {
            userServiceImp.removeAuthority(testUser.getUsername(), "ADMIN");
        });
    }

    @Test
    public void testAddAuthority2() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(false);
        assertThrows(UsernameNotFoundException.class, () -> {
            userServiceImp.addAuthority(testUser.getUsername(), "ADMIN");
        });
    }

    @Test
    public void testGetAuthorities2() {
        User testUser = new User();
        testUser.setUsername("testUsername");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(false);
        assertThrows(UsernameNotFoundException.class, () -> {
            userServiceImp.getAuthorities(testUser.getUsername());
        });
    }

    @Test
    public void testUpdateUser2(){
        User testUser = new User();
        testUser.setUsername("testUsername");
        User testUser2 = new User();
        testUser2.setUsername("testUsername2");
        when(userRepository.existsById(testUser.getUsername())).thenReturn(false);
        assertThrows(NotFoundException.class, ()-> {
            userServiceImp.updateUser(testUser.getUsername(), testUser2);
        });
    }

}


