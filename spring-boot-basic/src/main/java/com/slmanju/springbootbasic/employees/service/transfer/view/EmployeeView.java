package com.slmanju.springbootbasic.employees.service.transfer.view;

import com.slmanju.springbootbasic.employees.repository.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

  private Long id;
  private String firstName;
  private String lastName;
  private Gender gender;

}
