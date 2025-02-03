package com.example.demo.service;

import com.example.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private Long currentId = 1L;

    // CRUD Methods
    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        task.setId(currentId++);
        tasks.add(task);
        return task;
    }

    public Optional<Task> getTasksById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> taskOpt = getTasksById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return task;
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}