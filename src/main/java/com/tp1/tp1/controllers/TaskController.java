package com.tp1.tp1.controllers;

import com.tp1.tp1.entities.Task;
import com.tp1.tp1.services.interfaces.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    ResponseEntity<List<Task>> getAllProjects() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

}
