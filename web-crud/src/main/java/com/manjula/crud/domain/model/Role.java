package com.manjula.crud.domain.model;

import com.manjula.crud.service.view.RoleView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "role_name")
    private String name;

    public RoleView view() {
        RoleView view = RoleView.instance();
        BeanUtils.copyProperties(this, view);
        return view;
    }

    public static Role valueOf(RoleView view) {
        Role role = new Role();
        BeanUtils.copyProperties(view, role);
        return role;
    }

}
