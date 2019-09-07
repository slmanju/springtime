package com.slmanju.springhibernatevalidator.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Valid email is required")
    @Email(message = "Valid email is required")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
