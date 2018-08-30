package com.manjula.relationships.manytoone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "many_to_one_department")
@Entity
public class ManyToOneDepartment {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    private String name;

//    @OneToMany(mappedBy="department")
//    private Set<ManyToOneEmployee> employees = new HashSet<>();

    public static ManyToOneDepartment instance(String name) {
        return ManyToOneDepartment.builder().name(name).build();
    }

    public ManyToOneDepartmentDTO toDto() {
        return ManyToOneDepartmentDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

}
