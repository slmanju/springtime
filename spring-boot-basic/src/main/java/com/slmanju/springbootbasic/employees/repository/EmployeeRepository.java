package com.slmanju.springbootbasic.employees.repository;

import com.slmanju.springbootbasic.employees.repository.entity.Employee;
import com.slmanju.springbootbasic.employees.service.transfer.dto.EmployeeSearchRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Manjula Jayawardana <manjulajayawardana@gmail.com>
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query("SELECT employee FROM Employee employee")
  Page<Employee> search(@Param("searchRequest") EmployeeSearchRequest searchRequest, Pageable pageable);

}
