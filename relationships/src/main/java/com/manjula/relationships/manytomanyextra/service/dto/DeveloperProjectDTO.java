package com.manjula.relationships.manytomanyextra.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DeveloperProjectDTO {

    private ProjectDTO projectDTO;
    private String task;

}
