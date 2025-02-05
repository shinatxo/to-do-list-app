package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private List<Task> tasks = new ArrayList<>();
    private Long currentId = 1L;

    // CRUD Methods
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        task.setId(currentId.toString());
        currentId++;
        tasks.add(task);
        return taskRepository.save(task);
   }

    public Optional<Task> getTasksById(String id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(String id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.isCompleted());
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}