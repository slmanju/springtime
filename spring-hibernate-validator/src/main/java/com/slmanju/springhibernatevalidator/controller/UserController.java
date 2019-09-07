package com.slmanju.springhibernatevalidator.controller;

import com.slmanju.springhibernatevalidator.service.UserService;
import com.slmanju.springhibernatevalidator.service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> save(UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok("validations fired");
    }

}
