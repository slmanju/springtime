package com.manjula.relationships.manytomanyextra.idclass.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class ManyToManyExtraDeveloperProjectId implements Serializable {

    private Long developer;
    private Long project;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ManyToManyExtraDeveloperProjectId that = (ManyToManyExtraDeveloperProjectId) o;

        if (!developer.equals(that.developer)) return false;
        return project.equals(that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developer, project);
    }

}
