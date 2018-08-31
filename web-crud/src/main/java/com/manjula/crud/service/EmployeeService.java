package com.manjula.crud.service;

import com.manjula.crud.domain.model.Employee;
import com.manjula.crud.service.view.EmployeeView;
import com.manjula.crud.service.view.RoleView;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeView employee);

    List<Employee> findAll();

    EmployeeView findByUsername(String username);

    List<RoleView> findAllRoles();

}
