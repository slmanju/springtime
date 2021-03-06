package com.slmanju.springsecurity.restsecurity.config;

import com.slmanju.springsecurity.restsecurity.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * Filter for other requests to check JWT in header
 * responsible for taking the token and re-identify the logged user from it
 */
public class JwtAuthenticationFilter extends GenericFilterBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    
    private final LoginService loginService;

    public JwtAuthenticationFilter(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("Process request to check for a JSON Web Token ");
        String authHeader = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);
        
        bearerToken(authHeader).ifPresent(this::loadUserAndSetAuthentication);
        
        filterChain.doFilter(request, response); //move on to the next filter in the chains
    }
    
    private void loadUserAndSetAuthentication(String token) {
        loginService.loadUserByJwt(token).ifPresent(this::setAuthentication);
    }
    
    private void setAuthentication(UserPrincipal userPrincipal) {
        Authentication authentication = new PreAuthenticatedAuthenticationToken(userPrincipal, "", userPrincipal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    
    private Optional<String> bearerToken(String authHeader) {
        if (authHeader != null && authHeader.startsWith(JwtUtils.TOKEN_PREFIX)) {
            return Optional.of(authHeader.replace(JwtUtils.TOKEN_PREFIX, "").trim());
        }
        return Optional.empty();
    }

}
