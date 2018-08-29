package com.manjula.relationships.selfreference.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select distinct employee from Employee employee " +
            "left join employee.subordinates " +
            "where employee.employeeType = com.manjula.relationships.selfreference.domain.EmployeeType.MANAGER")
    List<Employee> findAllManagers();

}
