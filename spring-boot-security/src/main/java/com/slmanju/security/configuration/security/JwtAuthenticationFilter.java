package com.slmanju.security.configuration.security;

import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Filter for other requests to check JWT in header.
 * Responsible for taking the token and re-identify the logged user from it.
 *
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public class JwtAuthenticationFilter extends GenericFilterBean {

  private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

  private final JwtTokenProvider jwtTokenProvider;

  public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    LOGGER.info("Process request to check for a JSON Web Token ");
    String authHeader = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);

    getBearerToken(authHeader).ifPresent(this::loadUserAndSetAuthentication);

    // move on to the next filter in the chain
    filterChain.doFilter(request, response);
  }

  private Optional<String> getBearerToken(String authHeader) {
    if (authHeader != null && authHeader.startsWith("Bearer")) {
      return Optional.of(authHeader.replace("Bearer", "").trim());
    }
    return Optional.empty();
  }

  private void loadUserAndSetAuthentication(String token) {
    findByJwt(token).ifPresent(userPrincipal -> {
      Authentication authentication = new PreAuthenticatedAuthenticationToken(userPrincipal, "", userPrincipal.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    });
  }

  private Optional<UserPrincipal> findByJwt(String token) {
    LOGGER.info("load user by jwt token");
    if (!jwtTokenProvider.isValidToken(token)) {
      return Optional.empty();
    }
    Claims claims = jwtTokenProvider.parse(token);
    List<GrantedAuthority> roles = jwtTokenProvider.getRoles(claims);

    EmployeeDto employeeDto = new EmployeeDto();
    employeeDto.setId(jwtTokenProvider.getId(claims));
    employeeDto.setUsername(jwtTokenProvider.getUsername(claims));
    employeeDto.setPassword("");
    employeeDto.setFirstName(jwtTokenProvider.getFirstName(claims));
    employeeDto.setLastName(jwtTokenProvider.getLastName(claims));

    return Optional.of(new UserPrincipal(employeeDto, SampleAuthority.authorities()));
  }

}
