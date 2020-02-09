package com.slmanju.security.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class JwtTokenProvider {

  private static final long EXPIRATION_TIME = 86400; // validity 1 day in seconds
  private static final String SECRET_KEY = Base64.getEncoder().encodeToString("these violent delights have violent ends".getBytes());

  public String token(Authentication authentication) {
    UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
    Claims claims = Jwts.claims().setSubject(user.getUsername());
    claims.put("id", user.getId());
    claims.put("roles", user.getRoles());

    Date now = new Date();
    Date expiresAt = new Date(now.getTime() + EXPIRATION_TIME);
    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(expiresAt)
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
  }

  public Claims parse(String token) {
    return Jwts.parser()
        .setSigningKey(SECRET_KEY)
        .parseClaimsJws(token.replace("Bearer", ""))
        .getBody();
  }

  public Integer getId(Claims claims) {
    return (Integer) claims.get("id");
  }

  public String getUsername(Claims claims) {
    return claims.getSubject();
  }

  public String getFirstName(Claims claims) {
    return (String) claims.get("firstName");
  }

  public String getLastName(Claims claims) {
    return (String) claims.get("lastName");
  }

  public List<GrantedAuthority> getRoles(Claims claims) {
    return SampleAuthority.grantedAuthorities(); // claims.get("roles", List.class);
  }

  public boolean isValidToken(String token) {
    try {
      Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }

}
