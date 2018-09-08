package com.manjula.relationships.manytomanyextra.domain.model;

import com.manjula.relationships.manytomanyextra.service.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_extra_project")
public class ManyToManyExtraProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "developer")
    private List<ManyToManyExtraDeveloperProject> developers;

    public static ManyToManyExtraProject instance(String name) {
        return ManyToManyExtraProject.builder()
                .name(name)
                .developers(Collections.emptyList())
                .build();
    }

    public ProjectDTO toDTO() {
        return ProjectDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

}
