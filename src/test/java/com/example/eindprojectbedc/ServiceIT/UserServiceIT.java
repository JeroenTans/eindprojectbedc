package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.UserServiceImp;
import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceIT {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImp userServiceImp;

//    @Test
//    public void saveUser(){
//        User user = new User();
//        user.setUsername("Jan");
//        userRepository.save(user);
//
//        List<Object> userList = Collections.singletonList(userServiceImp.getUser(user.getUsername()));
//        assertEquals(1, userList.size());
//    }

}
