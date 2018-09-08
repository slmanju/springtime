package com.manjula.relationships.manytomanyextra.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class ManyToManyExtraDeveloperProjectId implements Serializable {

    @Column(name = "developer_id")
    private Long developerId;
    @Column(name = "project_id")
    private Long projectId;

}
