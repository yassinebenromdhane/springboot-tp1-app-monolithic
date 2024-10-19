package com.tp1.tp1.services.interfaces;

import com.tp1.tp1.entities.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    Task createTask(Task task);
    public Task updateTask(Task task , UUID id);
    public void deleteTask(UUID id);
    public List<Task> getAllTasks();
    public Task getTaskById(UUID id);
    public List<Task> getTaskByProjectId(UUID id);
}
