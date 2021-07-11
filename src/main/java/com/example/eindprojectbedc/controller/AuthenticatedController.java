package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.Service.CustomUserDetailsService;
import com.example.eindprojectbedc.Service.UserServiceImp;
import com.example.eindprojectbedc.model.User;
import com.example.eindprojectbedc.payload.AuthenticationRequest;
import com.example.eindprojectbedc.payload.AuthenticationResponse;
import com.example.eindprojectbedc.repository.UserRepository;
import com.example.eindprojectbedc.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class AuthenticatedController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserServiceImp userService;

    @Autowired
    JwtUtil jwtUtl;

    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok().body(principal);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        User user = userRepository.getById(username);
        String authority = user.getAuthority();
        String groupName = user.getGroupName();
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setGroupName(groupName);
        authenticationResponse.setAuthorityRole(authority);
        authenticationResponse.setUsername(username);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtl.generateToken(userDetails);

        authenticationResponse.setJwt(jwt);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, username, authority, groupName));
    }
}
