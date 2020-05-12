package com.slmanju.springbootbasic.employees.service;

import com.slmanju.springbootbasic.core.SearchResult;
import com.slmanju.springbootbasic.employees.repository.entity.Employee;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeService {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  Optional<Employee> findById(Long id);

  Employee saveEmployee(EmployeeDto employeeDto);

  Employee updateEmployee(Long id, EmployeeDto employeeDto);

  void deleteEmployee(Long id);

}
