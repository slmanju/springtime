package com.slmanju.springbootbasic.employees.service.mapper;

import com.slmanju.springbootbasic.core.DataMapper;
import com.slmanju.springbootbasic.employees.repository.entity.Employee;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;

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
