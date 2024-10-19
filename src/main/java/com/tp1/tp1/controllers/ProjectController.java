package com.tp1.tp1.controllers;

import com.tp1.tp1.dtos.ProjectDto;
import com.tp1.tp1.entities.Project;
import com.tp1.tp1.entities.User;
import com.tp1.tp1.services.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/")
    ResponseEntity<ProjectDto> saveUser(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.addProject(project));
    }

    @GetMapping("/")
    ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
    @GetMapping("/{id}")
    ResponseEntity<Project> getOneProject(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProject(@PathVariable(value = "id") UUID id) {
        Project project = projectService.getProject(id);

        if (project == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Project with ID " + id + " not found.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        projectService.deleteProject(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Project deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProject(@PathVariable(value = "id") UUID id, @RequestBody Project project) {
        Project p = projectService.getProject(id);
        if (p == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Project with ID " + id + " not found.");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        Project updatedProject = projectService.updateProject(project, id);

        return ResponseEntity.ok(updatedProject);
    }
}
