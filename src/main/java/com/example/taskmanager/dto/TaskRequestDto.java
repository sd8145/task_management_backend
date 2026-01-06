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

import jakarta.validation.constraints.NotBlank;

/*
 * Task validation rules
 */

public class TaskRequestDto {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    private String description;
    private boolean completed;
    private Long userId;
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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
