package com.manjula.starter.controller;

import com.manjula.starter.service.EmployeeService;
import com.manjula.starter.service.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }

    @GetMapping(value = "/save")
    public String saveForm(Model model) {
        model.addAttribute("employee", EmployeeView.instance());
        return "employee/save";
    }

    @PostMapping(value = "/save")
    public String save(EmployeeView view) {
        employeeService.save(view);
        return "redirect:/employees";
    }

    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/view";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/save";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
