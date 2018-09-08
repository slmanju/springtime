package com.manjula.relationships.manytomanyextra.service;

import com.manjula.relationships.manytomanyextra.service.dto.DeveloperDTO;
import com.manjula.relationships.manytomanyextra.service.dto.ProjectDTO;

import java.util.List;

public interface ManyToManyExtraService {

    List<DeveloperDTO> findAllDevelopers();

    List<ProjectDTO> findAllProjects();

    List<DeveloperDTO> findDevelopers(Long projectId);

    List<ProjectDTO> findProjects(Long developerId);

    void assign(Long developerId, Long projectId, String task);

}
