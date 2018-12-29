package com.slmanju.springsecurity.restsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.springsecurity.restsecurity.service.LoginService;
import com.slmanju.springsecurity.restsecurity.view.LoginView;

@RestController
public class LoginController {

    private final LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping("/signin")
    public String login(@RequestBody LoginView loginView) {
        return loginService.login(loginView.getUsername(), loginView.getPassword());
    }
    
}
