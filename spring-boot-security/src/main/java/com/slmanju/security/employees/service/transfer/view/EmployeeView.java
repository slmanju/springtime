package com.slmanju.security.employees.service.transfer.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;

}
