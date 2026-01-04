package com.example.taskmanager.dto;

/*
 * TaskResponseDto
 * ----------------
 * Represents data returned to the client.
 *
 * Server controls:
 * - id
 * - task data
 */

public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TaskResponseDto(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}