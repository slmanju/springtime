package com.manjula.starter.service.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

    private Long id;
    private String username;

    public static EmployeeView instance() {
        return EmployeeView.builder().build();
    }

}
