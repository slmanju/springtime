package com.manjula.relationships.selfreference.service;

import com.manjula.relationships.selfreference.domain.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllManagers();

}
