package com.tp1.tp1.services.interfaces;

import com.tp1.tp1.dtos.ProjectDto;
import com.tp1.tp1.entities.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface ProjectService {
    ProjectDto addProject(Project project);
    Project updateProject(Project project , UUID id);
    void deleteProject( UUID id);
    Project getProject(UUID id);
    List<Project> getAllProjects();
}
