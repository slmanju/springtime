package com.slmanju.springbootbasic.employees.controller;

import com.slmanju.springbootbasic.core.SearchResult;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeControllerSpec {

  @GetMapping(value = "/api/employees/search/{start}/{size}")
  ResponseEntity<SearchResult<EmployeeView>> search(@PathVariable int start, @PathVariable int size, EmployeeSearchRequest searchRequest);

  @GetMapping(value = "/api/employees/{id}")
  ResponseEntity<EmployeeView> findEmployee(@PathVariable("id") Long id);

  @PostMapping(value = "/api/employees")
  ResponseEntity<EmployeeView> createEmployee(@RequestBody EmployeeDto employeeDto);

  @PutMapping(value = "/api/employees/{id}")
  ResponseEntity<EmployeeView> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto);

  @DeleteMapping(value = "/api/employees/{id}")
  ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id);

}
