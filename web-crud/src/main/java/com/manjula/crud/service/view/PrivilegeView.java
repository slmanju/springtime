package com.manjula.crud.service.view;

import lombok.Data;

@Data
public class PrivilegeView {

    private String id;
    private String code;
    private String name;
    private String description;

    public static PrivilegeView instance() {
        return new PrivilegeView();
    }

}
