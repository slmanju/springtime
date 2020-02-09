package com.slmanju.security.employees.service;

import com.slmanju.security.core.SearchResult;
import com.slmanju.security.employees.service.entity.Employee;
import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.security.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.security.employees.service.transfer.view.EmployeeView;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeService {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  Optional<Employee> findById(Integer id);

  Employee saveEmployee(EmployeeDto employeeDto);

  Employee updateEmployee(Integer id, EmployeeDto employeeDto);

  void deleteEmployee(Integer id);

}
