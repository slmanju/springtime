package com.manjula.relationships.manytomanyextra.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
//@Data @NoArgsConstructor @AllArgsConstructor
public class ManyToManyExtraDeveloperProjectId implements Serializable {

    @Column(name = "developer_id")
    private Long developerId;
    @Column(name = "project_id")
    private Long projectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ManyToManyExtraDeveloperProjectId that = (ManyToManyExtraDeveloperProjectId) o;

        if (!developerId.equals(that.developerId)) return false;
        return projectId.equals(that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developerId, projectId);
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}
