package com.manjula.crud.service.view;

import lombok.Data;

@Data
public class RoleView {

    private String id;
    private String name;

    public static RoleView instance() {
        return new RoleView();
    }

}
