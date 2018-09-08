package com.manjula.relationships.manytomanyextra.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "many_to_many_extra_developer_project")
@Data @NoArgsConstructor @AllArgsConstructor
public class ManyToManyExtraDeveloperProject {

    @EmbeddedId
    private ManyToManyExtraDeveloperProjectId developerProjectId;

    @ManyToOne
    @MapsId("developerId")
    private ManyToManyExtraDeveloper developer;
    @ManyToOne
    @MapsId("projectId")
    private ManyToManyExtraProject project;

    @Column
    private String task;

}
