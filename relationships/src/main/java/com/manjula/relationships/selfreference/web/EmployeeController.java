package com.manjula.relationships.selfreference.web;

import com.manjula.relationships.selfreference.domain.Employee;
import com.manjula.relationships.selfreference.domain.EmployeeDTO;
import com.manjula.relationships.selfreference.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAllManagers()
                .stream()
                .map(Employee::toDto)
                .collect(Collectors.toList());
    }

}
