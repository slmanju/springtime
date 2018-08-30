package com.manjula.relationships.manytoone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ManyToOneEmployeeDTO {

    private String id;
    private String name;
    private ManyToOneDepartmentDTO department;

}
