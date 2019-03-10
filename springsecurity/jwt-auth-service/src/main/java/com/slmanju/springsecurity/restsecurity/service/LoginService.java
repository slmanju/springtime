package com.slmanju.springsecurity.restsecurity.service;

import java.util.Optional;

import com.slmanju.springsecurity.restsecurity.config.UserPrincipal;

public interface LoginService {

    String login(String username, String password);
    
    Optional<UserPrincipal> loadUserByJwtToken(String token);

}
