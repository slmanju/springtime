package com.manjula.relationships.selfreference.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "employee_type") @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    @NotFound(action= NotFoundAction.IGNORE)
    private Employee manager;
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Employee> subordinates = new ArrayList<>();

    public static Employee instance(String name, EmployeeType employeeType) {
        return Employee.builder().name(name).employeeType(employeeType).build();
    }

    public EmployeeDTO toDto() {
        Employee employee = this;
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .employeeType(employee.getEmployeeType())
                .build();
        List<Employee> subordinates = employee.getSubordinates();
        if (subordinates != null) {
            List<EmployeeDTO> subDtos = new ArrayList<>();
            for (Employee subordinate : subordinates) {
                EmployeeDTO sub = subordinate.toDto();
                subDtos.add(sub);
            }
            employeeDTO.setSubordinates(subDtos);
        }
        return employeeDTO;
    }

}
