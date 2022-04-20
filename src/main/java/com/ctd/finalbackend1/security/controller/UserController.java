package com.ctd.finalbackend1.security.controller;


import com.ctd.finalbackend1.security.UserDetailsServiceImpl;
import com.ctd.finalbackend1.security.repository.IUserRepository;
import com.sun.net.httpserver.Headers;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    private UserDetailsServiceImpl userService;
    @Autowired
    public UserController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> login() {
        return null;
    }

}
