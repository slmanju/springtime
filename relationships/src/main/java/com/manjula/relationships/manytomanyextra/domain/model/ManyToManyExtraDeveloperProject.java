package com.manjula.relationships.manytomanyextra.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "many_to_many_extra_developer_project")
public class ManyToManyExtraDeveloperProject implements Serializable {

    @EmbeddedId
    private ManyToManyExtraDeveloperProjectId id;

    @ManyToOne
    @MapsId("developerId")
    private ManyToManyExtraDeveloper developer;

    @ManyToOne
    @MapsId("projectId")
    private ManyToManyExtraProject project;

    @Column(name = "project_task")
    private String task;

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
