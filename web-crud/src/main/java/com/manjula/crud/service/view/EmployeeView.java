package com.manjula.crud.service.view;

import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class EmployeeView {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
//    private Set<RoleView> roles = new HashSet<>();

    public static EmployeeView instance() {
        return new EmployeeView();
    }

}
