package com.manjula.relationships.selfreference.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data @Builder
public class EmployeeDTO {

    private String id;
    private String name;
    private EmployeeType employeeType;
    private List<EmployeeDTO> subordinates = new ArrayList<>();

}
