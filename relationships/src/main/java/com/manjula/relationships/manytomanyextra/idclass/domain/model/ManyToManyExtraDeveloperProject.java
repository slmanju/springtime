package com.manjula.relationships.manytomanyextra.idclass.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_extra_developer_project")
@IdClass(ManyToManyExtraDeveloperProjectId.class)
public class ManyToManyExtraDeveloperProject implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private ManyToManyExtraDeveloper developer;

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ManyToManyExtraProject project;

    @Column(name = "project_task")
    private String task;

    public static ManyToManyExtraDeveloperProject instance(
            ManyToManyExtraDeveloper developer,
            ManyToManyExtraProject project,
            String task) {
        ManyToManyExtraDeveloperProject developerProject = new ManyToManyExtraDeveloperProject();
        developerProject.setDeveloper(developer);
        developerProject.setProject(project);
        developerProject.setTask(task);
        return developerProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ManyToManyExtraDeveloperProject that = (ManyToManyExtraDeveloperProject) o;
        return Objects.equals(developer, that.developer) &&
                Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developer, project);
    }

}
