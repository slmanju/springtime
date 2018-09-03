package com.manjula.starter.domain.model;

import com.manjula.starter.service.view.EmployeeView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    public EmployeeView view() {
        EmployeeView view = EmployeeView.instance();
        BeanUtils.copyProperties(this, view);
        return view;
    }

    public static Employee valueOf(EmployeeView view) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(view, employee);
        return employee;
    }

}
