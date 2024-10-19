package com.tp1.tp1.services.implementations;

import com.tp1.tp1.entities.Task;
import com.tp1.tp1.repositories.TaskRepository;
import com.tp1.tp1.services.interfaces.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskServiceImp  implements TaskService {
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task getTaskById(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


    @Override
    public Task updateTask(Task task, UUID id) {
        Task t = getTaskById(id);
        if (t != null) {
            t.setTitle(task.getTitle());
            t.setDescription(task.getDescription());
            t.setDate(task.getDate());
            t.setStatus(task.getStatus());
            return taskRepository.save(task);
        }
        return null;
    }
    @Override
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
    @Override
    public List<Task> getTaskByProjectId(UUID projectId) {
        return taskRepository.findByProjectId(projectId);
    }
}
