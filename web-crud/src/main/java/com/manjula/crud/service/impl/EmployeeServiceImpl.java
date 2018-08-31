package com.manjula.crud.service.impl;

import com.manjula.crud.domain.model.Employee;
import com.manjula.crud.domain.model.Role;
import com.manjula.crud.domain.repository.EmployeeRepository;
import com.manjula.crud.domain.repository.RoleRepository;
import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.service.view.EmployeeView;
import com.manjula.crud.service.view.RoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(EmployeeView view) {
        view.setPassword(passwordEncoder.encode(view.getPassword()));
        employeeRepository.save(Employee.valueOf(view));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeView findByUsername(String username) {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        return employee.map(Employee::view).orElse(null);
    }

    @Override
    public List<RoleView> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleView> views = new ArrayList<>();
        roles.forEach(role -> views.add(role.view()));
        return views;
    }

}
