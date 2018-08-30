package com.manjula.relationships.manytoone.service;

import com.manjula.relationships.manytoone.domain.ManyToOneDepartmentDTO;
import com.manjula.relationships.manytoone.domain.ManyToOneEmployeeDTO;

import java.util.List;

public interface ManyToOneService {

    List<ManyToOneDepartmentDTO> findAllDepartments();

    List<ManyToOneEmployeeDTO> findAllEmployees();

}
