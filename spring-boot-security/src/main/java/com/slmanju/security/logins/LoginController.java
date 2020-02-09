package com.slmanju.security.logins;

import com.slmanju.security.configuration.security.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestController
public class LoginController {

  private final LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping("/login")
  public String login(@RequestBody LoginView loginView) {
    return loginService.login(loginView.getUsername(), loginView.getPassword());
  }

  @GetMapping("/me")
  public UserPrincipal me() {
    return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

}
