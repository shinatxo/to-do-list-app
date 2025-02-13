package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.badRequest().build();
        }
        ObjectId objectId = new ObjectId(id);
        Optional<Task> task = taskService.getTasksById(objectId);
        return task.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.badRequest().build();
        }
        ObjectId objectId = new ObjectId(id);
        Task task = taskService.updateTask(objectId, updatedTask);

        Optional<Task> existingTask = taskService.getTasksById(objectId);
        if (existingTask.isPresent()) {
            Task taskToUpdate = existingTask.get();

            if (updatedTask.getTitle() != null) {
                taskToUpdate.setTitle(updatedTask.getTitle());
            }
            if (updatedTask.getCompleted() != null) {
                taskToUpdate.setCompleted(updatedTask.getCompleted());
            }

            Task updated = taskService.updateTask(objectId, taskToUpdate);
            return ResponseEntity.ok(updated);
        }
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        if (!ObjectId.isValid(id)) {
            return ResponseEntity.badRequest().build();
        }
        ObjectId objectId = new ObjectId(id);
        taskService.deleteTask(objectId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Task createdTask = taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
}