package com.manjula.relationships.selfreferencemany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TwitterDTO {

    private Long id;
    private String name;

    public static TwitterDTO instance(String name) {
        return TwitterDTO.builder().name(name).build();
    }

}
