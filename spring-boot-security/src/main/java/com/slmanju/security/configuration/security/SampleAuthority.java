package com.slmanju.security.configuration.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class SampleAuthority {

  public static List<GrantedAuthority> grantedAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ADMIN"));
    authorities.add(new SimpleGrantedAuthority("USER"));

    return authorities;
  }

  public static List<String> authorities() {
    List<String> authorities = new ArrayList<>();
    authorities.add("ADMIN");
    authorities.add("USER");

    return authorities;
  }

}
