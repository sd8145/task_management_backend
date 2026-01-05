package com.example.taskmanager.dto;

/*
 * TaskRequestDto
 * ----------------
 * Represents data sent by the client
 * while creating a task.
 *
 * Client controls:
 * - title
 * - description
 * - completed
 *
 * Client does NOT control:
 * - id (DB responsibility)
 */

public class TaskRequestDto {

    private String title;
    private String description;
    private boolean completed;

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
}