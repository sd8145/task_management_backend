package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequestDto;
import com.example.taskmanager.dto.TaskResponseDto;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/*
 * TaskService
 * ------------
 * Handles business logic for tasks.
 * Converts DTO ↔ Entity.
 */

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    // Constructor Injection
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    /*
     * CREATE TASK
     */
    public TaskResponseDto createTask(TaskRequestDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + dto.getUserId())
                );

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        task.setUser(user);

        Task savedTask = taskRepository.save(task);

        return new TaskResponseDto(
                savedTask.getId(),
                savedTask.getTitle(),
                savedTask.getDescription(),
                savedTask.isCompleted()
        );
    }


    /*
     * GET TASK BY ID
     */
    public TaskResponseDto getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id)
                );

        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted()
        );
    }

    /*
     * DELETE TASK
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    public List<TaskResponseDto> getTasksByUserId(Long userId) {
    // 1. EXISTENCE CHECK: 
    // If we skip this and the user doesn't exist, we return an empty list [].
    // That is a "lie." A 404 is the honest answer for a user that doesn't exist.
    userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    // 2. FETCH & TRANSFORM:
    return taskRepository.findByUserId(userId).stream()
            .map(task -> new TaskResponseDto(task.getId(), task.getTitle(),task.getDescription(), task.isCompleted()))
            .collect(Collectors.toList());
}
public List<TaskResponseDto> getAllTasks() {
    return taskRepository.findAll().stream()
            .map(task -> new TaskResponseDto(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.isCompleted()
            ))
            .toList();
}

}