package com.manjula.relationships.manytomanyextra.idclass.domain.model;

import com.manjula.relationships.manytomanyextra.idclass.service.dto.DeveloperDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static java.util.Collections.emptyList;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_extra_developer")
public class ManyToManyExtraDeveloper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManyToManyExtraDeveloperProject> projects = emptyList();

    public static ManyToManyExtraDeveloper instance(String name) {
        return ManyToManyExtraDeveloper.builder()
                .name(name)
                .projects(emptyList())
                .build();
    }

    public void addProject(ManyToManyExtraProject project, String task) {
        ManyToManyExtraDeveloperProject developerProject = ManyToManyExtraDeveloperProject.instance(this, project, task);

        projects.add(developerProject);
    }

    public DeveloperDTO toDTO() {
        return DeveloperDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

}
