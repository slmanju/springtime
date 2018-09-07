package com.manjula.relationships.manytomany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ManyToManyTagDTO {

    private Long id;
    private String name;

    public static ManyToManyTagDTO instance(String name) {
        return ManyToManyTagDTO.builder().name(name).build();
    }

}
