package com.slmanju.security.employees.service.impl;

import com.slmanju.security.core.SearchResult;
import com.slmanju.security.employees.repository.EmployeeRepository;
import com.slmanju.security.employees.service.EmployeeService;
import com.slmanju.security.employees.service.entity.Employee;
import com.slmanju.security.employees.service.mapper.EmployeeMapper;
import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.security.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.security.employees.service.transfer.view.EmployeeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final EmployeeMapper employeeMapper;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest) {
    Sort sort = Sort.by("id").ascending();
    PageRequest pageRequest = PageRequest.of(searchRequest.getStart(), searchRequest.getSize(), sort);

    Page<Employee> page = employeeRepository.search(searchRequest, pageRequest);

    return SearchResult.of(page, employeeMapper);
  }

  @Override
  public Optional<Employee> findById(Integer id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Employee saveEmployee(EmployeeDto employeeDto) {
    Employee employee = employeeMapper.toEntity(employeeDto);

    return employeeRepository.save(employee);
  }

  @Override
  public Employee updateEmployee(Integer id, EmployeeDto employeeDto) {
    Optional<Employee> employeeOptional = findById(id);

    Employee employee = employeeOptional.map(saved -> employeeMapper.toUpdateEntity(employeeDto, saved)).orElse(null);

    return employeeRepository.save(employee);
  }

  @Override
  public void deleteEmployee(Integer id) {
    employeeRepository.deleteById(id);
  }

}
