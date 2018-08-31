package com.manjula.crud.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.manjula.crud.service.view.PrivilegeView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "privilege")
@Data
public class Privilege {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Privilege() {
        
    }
    
    public static Privilege getInstance(PrivilegeView view) {
        Privilege privilege = new Privilege();
        privilege.setId(view.getId());
        privilege.setCode(view.getCode());
        privilege.setName(view.getName());
        privilege.setDescription(view.getDescription());
        return privilege;
    }
    
    public static List<PrivilegeView> views(List<Privilege> privileges) {
        List<PrivilegeView> privilegeViews = new ArrayList<>();
        for (Privilege privilege : privileges) {
            privilegeViews.add(privilege.view());
        }
        return privilegeViews;
    }
    
    public PrivilegeView view() {
        PrivilegeView view = new PrivilegeView();
        view.setId(id);
        view.setCode(code);
        view.setName(name);
        view.setDescription(description);
        return view;
    }

}
