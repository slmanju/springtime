package com.manjula.relationships.manytomany.extracolumn.idclass.domain.model;

import com.manjula.relationships.manytomany.extracolumn.idclass.service.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

import static java.util.Collections.emptyList;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "many_to_many_extra_project")
@NaturalIdCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ManyToManyExtraProject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ManyToManyExtraDeveloperProject> developers = emptyList();

    public static ManyToManyExtraProject instance(String name) {
        return ManyToManyExtraProject.builder()
                .name(name)
                .developers(emptyList())
                .build();
    }

    public ProjectDTO toDTO() {
        return ProjectDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

}
