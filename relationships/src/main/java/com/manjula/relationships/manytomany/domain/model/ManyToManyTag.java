package com.manjula.relationships.manytomany.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_tag")
public class ManyToManyTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<ManyToManyPost> posts = new HashSet<>();

    public static ManyToManyTag instance(String name) {
        return ManyToManyTag.builder().name(name).posts(new HashSet<>()).build();
    }

    public ManyToManyTagDTO toDto() {
        return ManyToManyTagDTO.builder().id(id).name(name).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManyToManyTag tag = (ManyToManyTag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
