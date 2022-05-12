package com.wf3.demospringsecurity.controller;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @RolesAllowed("USER")
    @RequestMapping("/**") 
    public String getUser() {
        return "Welcome, User !";
    }

    @RolesAllowed({"USER","ADMIN"})
    @RequestMapping("/admin") 
    public String getAdmin() {
        return "Welcome, Admin !";
    }

    @RolesAllowed({"USER","ADMIN"})
    @RequestMapping("/myAccount")
    public String getMyAccount() {
        return "Welcome to myAccount page, Admin !";
    }

    @GetMapping("/*")
    public String getGitHub(Principal user) {
        return "Welcome, " + user.getName();
    }
}
