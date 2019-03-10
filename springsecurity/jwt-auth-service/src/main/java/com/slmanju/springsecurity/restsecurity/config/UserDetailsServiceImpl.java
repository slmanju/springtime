package com.slmanju.springsecurity.restsecurity.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.slmanju.springsecurity.restsecurity.view.UserView;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("load user by username %s", username);
        if (!username.equals("manjula")) {
            throw new UsernameNotFoundException("not found");
        }
        String[] roles = { "ADMIN", "MANAGER" };
        UserView userView = new UserView();
        userView.setId(UUID.randomUUID().toString());
        userView.setFirstName("Manjula");
        userView.setLastName("Jayawardana");
        userView.setUsername("manjula");
        userView.setPassword(passwordEncoder.encode("password"));
        userView.setRoles(roles);
        return new UserPrincipal(userView);
    }

}
