package com.manjula.relationships.onetoone.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "one_to_one_post_details")
public class OneToOnePostDetails {

    @Id
    private Long id;
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private OneToOnePost post;

    public static OneToOnePostDetails instance(String description, OneToOnePost post) {
        return OneToOnePostDetails.builder().description(description).post(post).build();
    }

    public OneToOnePostDetailsDTO toDto() {
        return OneToOnePostDetailsDTO.builder().id(id).description(description).build();
    }

}
