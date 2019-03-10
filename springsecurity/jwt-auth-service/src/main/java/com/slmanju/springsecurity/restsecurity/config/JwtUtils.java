package com.slmanju.springsecurity.restsecurity.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class JwtUtils {

    private static final long EXPIRATION_TIME = 86400; // validity 1 day in seconds
    private static final String SECRET_KEY = Base64.getEncoder().encodeToString("these violent delights have violent ends".getBytes());
    public static final String TOKEN_PREFIX = "Bearer";

    public static String authorization(Authentication authentication) {
        return TOKEN_PREFIX + " " + token(authentication);
    }

    public static String token(Authentication authentication) {
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

    public static Claims parse(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
    }

    public static String getId(Claims claims) {
        return (String) claims.get("id");
    }

    public static String getUsername(Claims claims) {
        return claims.getSubject();
    }

    public static List<SimpleGrantedAuthority> getRoles(Claims claims) {
        List<String> roles = claims.get("roles", List.class);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
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
