package com.manjula.relationships.manytoone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "many_to_one_employee")
@Entity
public class ManyToOneEmployee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    private String name;
    @ManyToOne
    @JoinColumn(name="department_id")
    private ManyToOneDepartment department;

    public static ManyToOneEmployee instance(String name, ManyToOneDepartment department) {
        return ManyToOneEmployee.builder().name(name).department(department).build();
    }

    public ManyToOneEmployeeDTO toDto() {
        return ManyToOneEmployeeDTO.builder()
                .id(id)
                .name(name)
                .department(department.toDto()).build();
    }

}
