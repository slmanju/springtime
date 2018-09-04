package com.manjula.relationships.onetoone.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OneToOnePostDetailsDTO {

    private Long id;
    private String description;

    public static OneToOnePostDetailsDTO instance(String description) {
        return OneToOnePostDetailsDTO.builder().description(description).build();
    }

}
