package com.slmanju.security.employees.service.delegator;

import com.slmanju.security.core.SearchResult;
import com.slmanju.security.employees.service.transfer.dto.EmployeeDto;
import com.slmanju.security.employees.service.transfer.dto.EmployeeSearchRequest;
import com.slmanju.security.employees.service.transfer.view.EmployeeView;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 **/
public interface EmployeeServiceDelegator {

  SearchResult<EmployeeView> search(EmployeeSearchRequest searchRequest);

  EmployeeView findById(Integer id);

  EmployeeView saveEmployee(EmployeeDto employeeDto);

  EmployeeView updateEmployee(Integer id, EmployeeDto employeeDto);

  void deleteEmployee(Integer id);

}
