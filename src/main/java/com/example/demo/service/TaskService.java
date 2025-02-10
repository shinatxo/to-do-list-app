package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // CRUD Methods
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
   }

    public Optional<Task> getTasksById(ObjectId id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(ObjectId id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTask.getTitle());
                    task.setCompleted(updatedTask.getCompleted());
                    return taskRepository.save(task);
                })
                .orElse(null);
    }

    public void deleteTask(ObjectId id) {
        taskRepository.deleteById(id);
    }
}