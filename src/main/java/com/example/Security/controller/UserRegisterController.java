package com.example.Security.controller;

import com.example.Security.config.SecurityConfig;
import com.example.Security.model.User;
import com.example.Security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/account")
public class UserRegisterController {

    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    UserRepo userRepo;

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        ResponseEntity<String> response = null;
        try
         {
            String password = securityConfig.passwordEncoder().encode(user.getPassword());
            String role = "ROLE_"+user.getRole();
            user.setRole(role);
            user.setPassword(password);
            userRepo.save(user);
            if (user.getId() > 0) {
                response = ResponseEntity
                            .status(HttpStatus.CREATED).body("User has been registered successfully");
            }else{
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username is already in use");
            }
        }catch(Exception ex){
              response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return  response;

    }

}
