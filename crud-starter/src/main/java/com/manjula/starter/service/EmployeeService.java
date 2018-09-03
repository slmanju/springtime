package com.manjula.starter.service;

import com.manjula.starter.service.view.EmployeeView;

import java.util.List;

public interface EmployeeService {

    void save(EmployeeView employeeView);

    void update(EmployeeView employeeView);

    EmployeeView findById(Long id);

    List<EmployeeView> findAll();

    EmployeeView findByUsername(String username);

    void delete(Long id);

}
