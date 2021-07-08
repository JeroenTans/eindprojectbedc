package com.example.eindprojectbedc.ServiceIT;

import com.example.eindprojectbedc.ServiceTest.UserServiceImp;
import com.example.eindprojectbedc.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserServiceIT {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImp userServiceImp;

    PasswordEncoder passwordEncoder;

    public UserServiceIT(UserRepository userRepository, UserServiceImp userServiceImp) {
        this.userRepository = userRepository;
        this.userServiceImp = userServiceImp;
    }

    @BeforeEach
    public void deleteAll(){ userRepository.deleteAll();}

//    @Test
//    public void itGetUsers(){
//        User user = new User();
//        Authority adminAuthority = new Authority();
//        adminAuthority.setAuthority("ADMIN");
//        user.addAuthority(adminAuthority);
//        user.setApikey(RandomStringGenerator.generateAlphaNumeric(20));
//        user.setUsername("jan");
//        user.setPassword("jaja");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEmail("jan@");
//        user.setResidence("Amsterdam");
//        userRepository.save(user);
//        Collection<User> userCollection = userRepository.findAll();
//        assertEquals(1, userCollection.size());
//    }

//    @Test
//    public void itCreateUser(User user){
//
//        Authority adminAuthority = new Authority();
//        adminAuthority.setAuthority("ADMIN");
//        user.addAuthority(adminAuthority);
//        user.setApikey(RandomStringGenerator.generateAlphaNumeric(20));
//        user.setUsername("jan");
//        user.setPassword("jaja");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEmail("jan@");
//        user.setResidence("Amsterdam");
//
//        User newUser = userRepository.save(user);
//
//        Collection<User> userList = userServiceImp.getUsers();
//        assertEquals(1, userList.size());
//    }

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
