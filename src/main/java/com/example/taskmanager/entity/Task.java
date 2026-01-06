package com.example.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// primary key for tasks 

    private String title;
    private String description;
    private boolean completed;
    // --- RELATIONSHIP START ---
    @ManyToOne
    @JoinColumn(name = "user_id") 
    /*Think of @JoinColumn as a Bridge.

In Java, you have a User Object (Name, Email, etc.).

In the Database, you have a Number (user_id).

@JoinColumn(name = "user_id") tells Hibernate: "When you see this User object in Java, don't try to cram the whole person into the Task table. Just grab the User's ID and put it in a column called user_id." */
    private User user;
    // --- RELATIONSHIP END ---
    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    // Getter: Used by Hibernate to read the relationship
public User getUser() {
    return user;
}

// Setter: Used by TaskService to establish the link
public void setUser(User user) {
    this.user = user;
}
}
