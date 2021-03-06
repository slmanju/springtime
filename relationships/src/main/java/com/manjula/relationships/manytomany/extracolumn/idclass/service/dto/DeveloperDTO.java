package com.manjula.relationships.manytomany.extracolumn.idclass.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DeveloperDTO {

    private Long id;
    private String name;

}
