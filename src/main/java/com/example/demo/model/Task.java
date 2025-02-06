package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "tasks")
public class Task {

    @Id
   private ObjectId id;
   

   @NotBlank(message = "Title is required")
   private String title;

   @NotNull(message = "Completed status is required")
   private Boolean completed;

   // Constructors
   public Task() {}
   
   public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // Getters and Setters
    public String getId() { 
        return id != null ? id.toHexString() : null;
    }
    public void setId(ObjectId id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
   }
