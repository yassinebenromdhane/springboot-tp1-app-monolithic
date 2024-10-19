package com.tp1.tp1.services.implementations;

import com.tp1.tp1.dtos.ProjectDto;
import com.tp1.tp1.entities.Project;
import com.tp1.tp1.repositories.ProjectRepository;
import com.tp1.tp1.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto addProject(Project project) {
        Project newProject = projectRepository.save(project);
        return modelMapper.map(newProject, ProjectDto.class);
    }

    @Override
    public Project updateProject(Project project, UUID id) {
        Project p = projectRepository.findById(id).orElse(null);
        if(p != null) {
            p.setName(project.getName());
            p.setDescription(project.getDescription());
            p.setStartDate(project.getStartDate());
            p.setEndDate(project.getEndDate());
            return projectRepository.save(p);
        }
        return null;
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepository.findById(id).ifPresent(projectRepository::delete);
    }

    @Override
    public Project getProject(UUID id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
