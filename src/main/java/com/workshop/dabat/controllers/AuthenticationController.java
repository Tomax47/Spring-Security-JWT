package com.workshop.dabat.controllers;

import com.workshop.dabat.Config.JwtUtil;
import com.workshop.dabat.dao.UserDao;
import com.workshop.dabat.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDetailsService;
    private final JwtUtil jwtUtil;


    @GetMapping("/login")
    public String getLoginPage() {
        return "sign_in_page";
    }

    @PostMapping("/Authenticate")
    public ResponseEntity<String> authenticate(
            @ModelAttribute AuthenticationRequest request
    ) {
        System.out.println("AuthBody : "+request.getEmail()+" "+request.getPassword());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = userDetailsService.findUserByEmail(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        } else {
            return ResponseEntity.status(400).body("An unknown error has occurred!");
        }
    }
}
