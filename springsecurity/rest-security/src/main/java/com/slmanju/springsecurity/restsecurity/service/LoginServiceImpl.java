package com.slmanju.springsecurity.restsecurity.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.slmanju.springsecurity.restsecurity.config.JwtUtils;
import com.slmanju.springsecurity.restsecurity.config.UserPrincipal;
import com.slmanju.springsecurity.restsecurity.view.UserView;

import io.jsonwebtoken.Claims;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(String username, String password) {
        LOGGER.info("user attempting to sign in %s", username);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return JwtUtils.generate(authentication);
    }

    @Override
    public Optional<UserPrincipal> loadUserByJwtToken(String token) {
        LOGGER.info("load user by jwt token");
        Claims claims = JwtUtils.parse(token);
        List<SimpleGrantedAuthority> roles = JwtUtils.getRoles(claims);
        List<String> authorities = roles.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList());
        
        UserView userView = new UserView();
        userView.setId(JwtUtils.getId(claims));
        userView.setUsername(JwtUtils.getUsername(claims));
        userView.setPassword("");
        userView.setRoles(authorities.toArray(new String[authorities.size()]));
        
        UserPrincipal principal = new UserPrincipal(userView);
        
        return Optional.of(principal);
    }

}
