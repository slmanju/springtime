package com.slmanju.security.configuration.security;

import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public class UserPrincipal extends User {

  private Integer id;
  private List<String> roles;

  // User(String username, String password, Collection<? extends GrantedAuthority> authorities)
  public UserPrincipal(EmployeeDto userDto, List<String> authorities) {
    super(userDto.getUsername(), userDto.getPassword(), SampleAuthority.grantedAuthorities());
    this.id = userDto.getId();
    this.roles = authorities;
  }

  public Integer getId() {
    return id;
  }

  public List<String> getRoles() {
    return roles;
  }

}
