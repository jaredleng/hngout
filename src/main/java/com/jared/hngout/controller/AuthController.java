package com.jared.hngout.controller;
import com.jared.hngout.dto.MemberDto;
import com.jared.hngout.dto.RegisterRequest;
import com.jared.hngout.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
     public ResponseEntity<?> register(
             @Valid @RequestBody RegisterRequest request){
        try{
            MemberDto member=authService.register(request);
            return ResponseEntity.status(201).body(member);


        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }




}
