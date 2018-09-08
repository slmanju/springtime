package com.manjula.relationships.manytomanyextra.idclass.web;

import com.manjula.relationships.manytomanyextra.idclass.service.ManyToManyExtraService;
import com.manjula.relationships.manytomanyextra.idclass.service.dto.DeveloperDTO;
import com.manjula.relationships.manytomanyextra.idclass.service.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manytomanyextra")
public class ManyToManyExtraController {

    @Autowired
    private ManyToManyExtraService service;

    @GetMapping("/developers")
    public List<DeveloperDTO> findAllDevelopers() {
        return service.findAllDevelopers();
    }

    @GetMapping("/projects")
    public List<ProjectDTO> findAllProjects() {
        return service.findAllProjects();
    }

    @GetMapping("/assign/{developerId}/{projectId}/{task}")
    public void assign(@PathVariable("developerId") Long developerId,
                       @PathVariable("projectId") Long projectId,
                       @PathVariable("task") String task) {
        service.assign(developerId, projectId, task);
    }

}
