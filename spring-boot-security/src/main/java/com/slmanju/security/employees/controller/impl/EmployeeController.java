package com.slmanju.security.employees.controller.impl;

import com.slmanju.security.core.SearchResult;
import com.slmanju.security.employees.controller.EmployeeControllerSpec;
import com.slmanju.security.employees.service.delegator.EmployeeServiceDelegator;
import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.security.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.security.employees.service.transfer.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestController
public class EmployeeController implements EmployeeControllerSpec {

  private final EmployeeServiceDelegator employeeServiceDelegator;

  @Autowired
  public EmployeeController(EmployeeServiceDelegator employeeServiceDelegator) {
    this.employeeServiceDelegator = employeeServiceDelegator;
  }

  @Override
  public ResponseEntity<SearchResult<EmployeeView>> search(int start, int size, EmployeeSearchRequest searchRequest) {
    searchRequest.setStart(start);
    searchRequest.setSize(size);

    SearchResult<EmployeeView> searchView = employeeServiceDelegator.search(searchRequest);

    return ResponseEntity.ok(searchView);
  }

  @Override
  public ResponseEntity<EmployeeView> findEmployee(Integer id) {
    EmployeeView employeeView = employeeServiceDelegator.findById(id);

    return ResponseEntity.ok(employeeView);
  }

  @Override
  public ResponseEntity<EmployeeView> createEmployee(EmployeeDto employeeDto) {
    EmployeeView employeeView = employeeServiceDelegator.saveEmployee(employeeDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(employeeView);
  }

  @Override
  public ResponseEntity<EmployeeView> updateEmployee(Integer id, EmployeeDto employeeDto) {
    EmployeeView employeeView = employeeServiceDelegator.updateEmployee(id, employeeDto);

    return ResponseEntity.ok(employeeView);
  }

  @Override
  public ResponseEntity<Void> deleteEmployee(Integer id) {
    employeeServiceDelegator.deleteEmployee(id);

    return ResponseEntity.noContent().build();
  }

}
