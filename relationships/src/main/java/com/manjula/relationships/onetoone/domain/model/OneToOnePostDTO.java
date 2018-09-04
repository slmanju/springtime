package com.manjula.relationships.onetoone.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OneToOnePostDTO {

    private Long id;
    private String title;
    private OneToOnePostDetailsDTO details;

    public static OneToOnePostDTO instance(String title) {
        return OneToOnePostDTO.builder().title(title).build();
    }

}
