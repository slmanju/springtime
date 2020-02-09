package com.slmanju.security.configuration.security;

import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service("appUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserDetailsServiceImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LOGGER.info("load user by username {}", username);
    if (!username.equals("manjula")) { // TODO hit the database
      throw new UsernameNotFoundException("user not found");
    }

    EmployeeDto employeeDto = EmployeeDto.builder()
        .id(1).firstName("Manjula").lastName("Jayawardana")
        .username("manjula").password(passwordEncoder.encode("password"))
        .build();

    return new UserPrincipal(employeeDto, SampleAuthority.authorities());
  }

}
