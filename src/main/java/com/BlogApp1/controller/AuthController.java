package com.BlogApp1.controller;

import com.BlogApp1.dto.LoginDto;
import com.BlogApp1.dto.SignUpDto;
import com.BlogApp1.entity.User;
import com.BlogApp1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    //http://localhost:8080/api/auth/sign-up
    public ResponseEntity<String> createUser(@RequestBody SignUpDto signUpDto){
        //this createUser taking one SignUp signUp Dto,the JSON object will go this signUp class.
        //the signup class take the JSON content , this JSON obj need to save in database,
        // only wether the email is exist, if doesnt exist then only create user.

        if (userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already Registered", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if ((userRepository.existsByUsername(signUpDto.getUsername()))){
            return new ResponseEntity<>("this username is already registered",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        userRepository.save(user);
        return new ResponseEntity<>("User Registered",HttpStatus.CREATED);

    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody LoginDto loginDto){
    //LoginDto loginDto it has data username and password given by user
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("Sign-In successfull",HttpStatus.OK);
    }
}
