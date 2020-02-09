package com.slmanju.security.employees.service.mapper;

import com.slmanju.security.core.DataMapper;
import com.slmanju.security.employees.service.entity.Employee;
import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.security.employees.service.transfer.view.EmployeeView;

import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Component
public class EmployeeMapper implements DataMapper<Employee, EmployeeView, EmployeeDto> {

  @Override
  public Employee entity() {
    return new Employee();
  }

  @Override
  public EmployeeView view() {
    return new EmployeeView();
  }

}
