package com.slmanju.security.employees.service.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Data
@Entity
@Table(name = "employees")
public class Employee {

  @Id
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String password;

}
