package com.manjula.starter.service.impl;

import com.manjula.starter.domain.model.Employee;
import com.manjula.starter.domain.repository.EmployeeRepository;
import com.manjula.starter.service.EmployeeService;
import com.manjula.starter.service.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(EmployeeView employeeView) {
        employeeRepository.save(Employee.valueOf(employeeView));
    }

    @Override
    public void update(EmployeeView employeeView) {
        employeeRepository.save(Employee.valueOf(employeeView));
    }

    @Override
    public EmployeeView findById(Long id) {
        return employeeRepository.findById(id).map(Employee::view).orElse(null);
    }

    @Override
    public List<EmployeeView> findAll() {
        return employeeRepository.findAll().stream()
                .map(Employee::view).collect(Collectors.toList());
    }

    @Override
    public EmployeeView findByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        return employee.map(Employee::view).orElse(null);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
