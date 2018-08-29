package com.manjula.relationships.selfreference.web;

import com.manjula.relationships.selfreference.domain.EmployeeDTO;
import com.manjula.relationships.selfreference.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> findAll() {
        return employeeService.findAllManagers();
    }

}
