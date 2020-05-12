package com.slmanju.springbootbasic.employees.controller.impl;

import com.slmanju.springbootbasic.core.SearchResult;
import com.slmanju.springbootbasic.employees.controller.EmployeeControllerSpec;
import com.slmanju.springbootbasic.employees.service.delegator.EmployeeServiceDelegator;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
@RestController
public class EmployeeController implements EmployeeControllerSpec {

  private final EmployeeServiceDelegator employeeServiceDelegator;

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
  public ResponseEntity<EmployeeView> findEmployee(Long id) {
    EmployeeView employeeView = employeeServiceDelegator.findById(id);

    return ResponseEntity.ok(employeeView);
  }

  @Override
  public ResponseEntity<EmployeeView> createEmployee(EmployeeDto employeeDto) {
    EmployeeView employeeView = employeeServiceDelegator.saveEmployee(employeeDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(employeeView);
  }

  @Override
  public ResponseEntity<EmployeeView> updateEmployee(Long id, EmployeeDto employeeDto) {
    EmployeeView employeeView = employeeServiceDelegator.updateEmployee(id, employeeDto);

    return ResponseEntity.ok(employeeView);
  }

  @Override
  public ResponseEntity<Void> deleteEmployee(Long id) {
    employeeServiceDelegator.deleteEmployee(id);

    return ResponseEntity.noContent().build();
  }

}
