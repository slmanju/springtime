package com.manjula.crud.controller;

import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.service.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("employee", EmployeeView.instance());
//        model.addAttribute("roles", employeeService.findAllRoles());
        return "employee/save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(EmployeeView view) {
        employeeService.save(view);
        return "redirect:/employee";
    }

}
