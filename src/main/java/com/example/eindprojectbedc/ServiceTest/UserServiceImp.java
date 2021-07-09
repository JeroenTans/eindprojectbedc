package com.example.eindprojectbedc.ServiceTest;

import com.example.eindprojectbedc.exception.NotFoundException;
import com.example.eindprojectbedc.model.Authority;
import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.repository.UserRepository;
import com.example.eindprojectbedc.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public ResponseEntity<Object> addGroupName(String username) {
        User user = userRepository.getById(username);
        user.setGroupName("Tipsy");
        userRepository.save(user);
        return null;
    }

    @Override
    public String createUser(User user) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
//        Authority authority = new Authority();
//        authority.setAuthority("USER");
//        user.addAuthority(authority);
        user.setApikey(randomString);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority("ADMIN");
        User newUser = userRepository.save(user);

        return newUser.getUsername();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new NotFoundException();
        User user = userRepository.findById(username).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
//        User user = userRepository.findById(username).get();
        User user = userRepository.getById(username);
        user.addAuthority(new Authority(username, authority));
        user.setAuthority(authority);
        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }
}
