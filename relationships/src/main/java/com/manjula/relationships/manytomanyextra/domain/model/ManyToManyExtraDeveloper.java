package com.manjula.relationships.manytomanyextra.domain.model;

import com.manjula.relationships.manytomanyextra.service.dto.DeveloperDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_extra_developer")
public class ManyToManyExtraDeveloper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "developer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ManyToManyExtraDeveloperProject> projects = Collections.emptyList();

    public static ManyToManyExtraDeveloper instance(String name) {
        return ManyToManyExtraDeveloper.builder()
                .name(name)
                .projects(Collections.emptyList())
                .build();
    }

    public DeveloperDTO toDTO() {
        return DeveloperDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

    public void addProject(ManyToManyExtraProject project, String task) {
        ManyToManyExtraDeveloperProject developerProject = new ManyToManyExtraDeveloperProject();
        developerProject.setDeveloper(this);
        developerProject.setProject(project);
        developerProject.setTask(task);

        projects.add(developerProject);
        project.getDevelopers().add(developerProject);
    }

}
