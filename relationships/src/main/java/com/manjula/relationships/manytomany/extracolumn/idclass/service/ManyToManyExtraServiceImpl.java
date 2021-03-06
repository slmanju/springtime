package com.manjula.relationships.manytomany.extracolumn.idclass.service;

import com.manjula.relationships.manytomany.extracolumn.idclass.domain.model.ManyToManyExtraDeveloper;
import com.manjula.relationships.manytomany.extracolumn.idclass.domain.model.ManyToManyExtraProject;
import com.manjula.relationships.manytomany.extracolumn.idclass.domain.repository.ManyToManyExtraDeveloperRepository;
import com.manjula.relationships.manytomany.extracolumn.idclass.domain.repository.ManyToManyExtraProjectRepository;
import com.manjula.relationships.manytomany.extracolumn.idclass.service.dto.DeveloperDTO;
import com.manjula.relationships.manytomany.extracolumn.idclass.service.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class ManyToManyExtraServiceImpl implements ManyToManyExtraService {

    @Autowired
    private ManyToManyExtraDeveloperRepository developerRepository;
    @Autowired
    private ManyToManyExtraProjectRepository projectRepository;

    @PostConstruct
    public void init() {
        ManyToManyExtraDeveloper developer1 = ManyToManyExtraDeveloper.instance("Iron Man");
        ManyToManyExtraDeveloper developer2 = ManyToManyExtraDeveloper.instance("Ant Man");
        ManyToManyExtraDeveloper developer3 = ManyToManyExtraDeveloper.instance("Wasp");

        developerRepository.save(developer1);
        developerRepository.save(developer2);
        developerRepository.save(developer3);

        ManyToManyExtraProject project1 = ManyToManyExtraProject.instance("Save Earth");

        projectRepository.save(project1);
    }

    @Override
    public List<DeveloperDTO> findAllDevelopers() {
        return developerRepository.findAll()
                .stream()
                .map(ManyToManyExtraDeveloper::toDTO)
                .collect(toList());
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ManyToManyExtraProject::toDTO)
                .collect(toList());
    }

    @Override
    public List<DeveloperDTO> findDevelopers(Long projectId) {
        return null;
    }

    @Override
    public List<ProjectDTO> findProjects(Long developerId) {
        return null;
    }

    @Override
    public void assign(Long developerId, Long projectId, String task) {
        ManyToManyExtraDeveloper developer = developerRepository.findById(developerId).get();

        ManyToManyExtraProject project = projectRepository.findById(projectId).get();

        developer.addProject(project, task);

        developerRepository.save(developer);
    }

}
