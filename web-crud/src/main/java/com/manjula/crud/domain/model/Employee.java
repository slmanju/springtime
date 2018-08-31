package com.manjula.crud.domain.model;

import com.manjula.crud.service.view.EmployeeView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    public EmployeeView view() {
        EmployeeView view = EmployeeView.instance();
        BeanUtils.copyProperties(this, view, "roles");
//        roles.forEach(role -> view.getRoles().add(role.view()));
        return view;
    }

    public static Employee valueOf(EmployeeView view) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(view, employee, "roles");
//        view.getRoles().forEach(roleView -> employee.getRoles().add(Role.valueOf(roleView)));
        return employee;
    }

}
