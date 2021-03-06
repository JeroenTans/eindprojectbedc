package com.example.eindprojectbedc.server.Service;

import com.example.eindprojectbedc.server.model.Authority;
import com.example.eindprojectbedc.server.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    public ResponseEntity<Object> addGroupName(String username);
    public abstract String createUser(User user);
    public abstract void updateUser(String username, User user);
    public abstract void deleteUser(String username);
    public abstract Collection<User> getUsers();
    List<User> getUsersByGroupName(String groupName);
    public abstract Optional<User> getUser(String username);
    public abstract boolean userExists(String username);
    public abstract Set<Authority> getAuthorities(String username);
    public abstract void addAuthority(String username, String authority);
    public abstract void removeAuthority(String username, String authority);
}
