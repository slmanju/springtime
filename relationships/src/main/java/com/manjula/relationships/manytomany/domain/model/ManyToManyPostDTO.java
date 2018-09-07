package com.manjula.relationships.manytomany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ManyToManyPostDTO {

    private Long id;
    private String title;
    private Set<ManyToManyTagDTO> tags = new HashSet<>();

    public static ManyToManyPostDTO instance(String title) {
        return ManyToManyPostDTO.builder().title(title).build();
    }

}
