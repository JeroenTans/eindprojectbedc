package com.example.eindprojectbedc.controller;

import com.example.eindprojectbedc.ServiceTest.CustomUserDetailsService;
import com.example.eindprojectbedc.ServiceTest.UserService;
import com.example.eindprojectbedc.ServiceTest.UserServiceImp;
import com.example.eindprojectbedc.model.Authority;
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
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class AuthenticatedController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

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
        User user = new User();
        String authority = user.getAuthority();
//        String authority = String.valueOf(userService.getAuthorities(username));
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAuthorityRole(authority);
        authenticationResponse.setUsername(username);
//        User user = userRepository.getById(username);
//        String authority = user.getAuthority();

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

        return ResponseEntity.ok(new AuthenticationResponse(jwt, username, authority));
//        return ResponseEntity.ok(authenticationResponse);
    }
}
