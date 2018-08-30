package com.manjula.relationships.manytoone.web;

import com.manjula.relationships.manytoone.domain.ManyToOneDepartmentDTO;
import com.manjula.relationships.manytoone.domain.ManyToOneEmployeeDTO;
import com.manjula.relationships.manytoone.service.ManyToOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManyToOneController {

    @Autowired
    private ManyToOneService manyToOneService;

    @GetMapping("/manytoone/departments")
    public List<ManyToOneDepartmentDTO> departments() {
        return manyToOneService.findAllDepartments();
    }

    @GetMapping("/manytoone/employees")
    public List<ManyToOneEmployeeDTO> employees() {
        return manyToOneService.findAllEmployees();
    }

}
