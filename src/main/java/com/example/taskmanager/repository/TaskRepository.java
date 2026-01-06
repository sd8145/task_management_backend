package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Explicitly telling JPA: "Learn how to search the tasks table using the user_id column"
     List<Task> findByUserId(Long userId);

}

