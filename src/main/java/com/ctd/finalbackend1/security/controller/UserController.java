package com.ctd.finalbackend1.security.controller;


import com.ctd.finalbackend1.security.UserDetailsServiceImpl;
import com.ctd.finalbackend1.security.component.JwtUtil;
import com.ctd.finalbackend1.security.repository.IUserRepository;
import com.sun.net.httpserver.Headers;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.get("username"),
                            loginRequest.get("password")
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginRequest.get("username"));
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getAuthorities()));
    }


    @GetMapping
    public ResponseEntity<?> login() {
        return null;
    }

    private class AuthenticationResponse {
        private final String jwt;
        private final Collection<? extends GrantedAuthority> authorities;
        public AuthenticationResponse(String jwt, Collection<? extends GrantedAuthority> authorities) {
            this.jwt = jwt;
            this.authorities = authorities;
        }
        public String getJwt() {
            return jwt;
        }
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }
    }
}


