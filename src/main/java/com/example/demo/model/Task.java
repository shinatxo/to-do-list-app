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
   public Task() {
   }
   
   public Task(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    // Getters and Setters

    public String getId() {
        return id.toHexString();
    }

    public void setId(String id) { 
        this.id = new ObjectId(id);
    }

    public String getTitle() { 
        return title; 
    }

    public void setTitle(String title) { 
        this.title = title; 
    }

    public Boolean getCompleted() { 
        return completed; 
    }

    public void setCompleted(Boolean completed) {
         this.completed = completed; 
    }
}
