package com.manjula.relationships.onetoone.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "one_to_one_post")
public class OneToOnePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OneToOnePostDetails details;

    public static OneToOnePost instance(String title) {
        return OneToOnePost.builder().title(title).build();
    }

    public OneToOnePostDTO toDto() {
        return OneToOnePostDTO.builder().id(id).title(title).build();
    }

    public OneToOnePostDTO toDetailedDto() {
        return OneToOnePostDTO.builder().id(id).title(title).details(details.toDto()).build();
    }

}
