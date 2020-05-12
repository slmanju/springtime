package com.slmanju.springbootbasic.employees.service.delegator;

import com.slmanju.springbootbasic.core.SearchResult;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.springbootbasic.employees.service.transfer.view.EmployeeView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeServiceDelegator {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  EmployeeView findById(Long id);

  EmployeeView saveEmployee(EmployeeDto employeeDto);

  EmployeeView updateEmployee(Long id, EmployeeDto employeeDto);

  void deleteEmployee(Long id);

}
