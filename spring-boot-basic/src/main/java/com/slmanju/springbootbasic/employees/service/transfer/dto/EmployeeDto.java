package com.slmanju.springbootbasic.employees.service.transfer.dto;

import com.slmanju.springbootbasic.employees.repository.entity.Gender;
import lombok.Data;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
public class EmployeeDto {

  private Long id;
  private String firstName;
  private String lastName;
  private Gender gender;

}
