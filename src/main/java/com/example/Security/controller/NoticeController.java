package com.example.Security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/account")
@CrossOrigin
public class NoticeController {

    @GetMapping(path = "/get-notice")
//    @Secured("ROLE_USER")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostAuthorize("hasAuthority('ROLE_USER')")
    public String getNotice() {
        return "Hello World";
    }
}
