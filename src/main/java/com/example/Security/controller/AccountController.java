package com.example.Security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/account")
@CrossOrigin
public class AccountController {

   @GetMapping(path = "/my-account")
    public String getAccountDetails() {
        return "Account Details";
    }
}

