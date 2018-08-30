package com.manjula.relationships.manytoone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ManyToOneDepartmentDTO {

    private String id;
    private String name;

//    private Set<ManyToOneEmployeeDTO> employees = new HashSet<>();

}
