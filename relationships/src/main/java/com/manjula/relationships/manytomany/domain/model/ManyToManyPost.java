package com.manjula.relationships.manytomany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_post")
public class ManyToManyPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "many_to_many_post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<ManyToManyTag> tags = new HashSet<>();

    public static ManyToManyPost instance(String title) {
        return ManyToManyPost.builder().title(title).tags(new HashSet<>()).build();
    }

    public void addTag(ManyToManyTag tag) {
        getTags().add(tag);
        tag.getPosts().add(this);
    }

    public void removeTag(ManyToManyTag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }

    public ManyToManyPostDTO toDto() {
        return ManyToManyPostDTO.builder().id(id).title(title).build();
    }

    public ManyToManyPostDTO toDetailedDto() {
        return ManyToManyPostDTO.builder()
                .id(id)
                .title(title)
                .tags(tags.stream().map(ManyToManyTag::toDto).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManyToManyPost)) return false;
        return id != null && id.equals(((ManyToManyPost) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
