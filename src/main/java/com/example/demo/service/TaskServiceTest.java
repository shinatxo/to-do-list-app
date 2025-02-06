package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleTask = new Task("Sample Task", false);
    }

    @Test
    void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(sampleTask));

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(1, tasks.size());
        assertEquals("Sample Task", tasks.get(0).getTitle());
        verify(taskRepository, times(1)).findAll();
    }

    @Test 
    void testAddTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);

        Task createdTask = taskService.addTask(sampleTask);

        assertNotNull(createdTask);
        assertEquals("Sample Task", createdTask.getTitle());
        verify(taskRepository, times(1)).save(sampleTask);
    }

    @Test
    void testGetTaskById() {
        ObjectId id = new ObjectId();
        when(taskRepository.findById(id)).thenReturn(Optional.of(sampleTask));

        Optional<Task> retrievedTask = taskService.getTasksById(id);

        assertTrue(retrievedTask.isPresent());
        assertEquals("Sample Task", retrievedTask.get().getTitle());
        verify(taskRepository, times(1)).findById(id);
    }

    @Test
    void testUpdateTask() {
        ObjectId id = new ObjectId();
        Task updatedTask = new Task("Updated Task", true);

        when(taskRepository.findById(id)).thenReturn(Optional.of(sampleTask));
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);

        Task result = taskService.updateTask(id, updatedTask);

        assertNotNull(result);
        assertEquals("Updated Task", result.getTitle());
        assertTrue(result.isCompleted());
        verify(taskRepository, times(1)).save(sampleTask);
    }

    @Test 
    void testDeleteTask() {
        ObjectId id = new ObjectId();
        doNothing().when(taskRepository).deleteById(id);
        taskService.deleteTask(id);
        verify(taskRepository, times(1)).deleteById(id);
    }
}