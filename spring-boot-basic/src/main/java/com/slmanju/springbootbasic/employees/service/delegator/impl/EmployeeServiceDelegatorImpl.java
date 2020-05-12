package com.slmanju.springbootbasic.employees.service.delegator.impl;

import com.slmanju.springbootbasic.core.SearchResult;
import com.slmanju.springbootbasic.employees.service.EmployeeService;
import com.slmanju.springbootbasic.employees.service.delegator.EmployeeServiceDelegator;
import com.slmanju.springbootbasic.employees.repository.entity.Employee;
import com.slmanju.springbootbasic.employees.service.mapper.EmployeeMapper;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class EmployeeServiceDelegatorImpl implements EmployeeServiceDelegator {

  private final EmployeeService employeeService;

  private final EmployeeMapper employeeMapper;

  public EmployeeServiceDelegatorImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
    this.employeeService = employeeService;
    this.employeeMapper = employeeMapper;
  }

  public SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest) {
    return employeeService.search(searchRequest);
  }

  public EmployeeView findById(Long id) {
    Optional<Employee> employee = employeeService.findById(id);

    return employee.map(employeeMapper::toView).orElse(null);
  }

  public EmployeeView saveEmployee(EmployeeDto employeeDto) {
    return employeeMapper.toView(employeeService.saveEmployee(employeeDto));
  }

  public EmployeeView updateEmployee(Long id, EmployeeDto employeeDto) {
    Employee employee = employeeService.updateEmployee(id, employeeDto);

    return employeeMapper.toView(employee);
  }

  public void deleteEmployee(Long id) {
    employeeService.deleteEmployee(id);
  }

}
