# Task Management System (REST API)

A robust backend service built with **Spring Boot**, focusing on industry-standard patterns like Layered Architecture, Data Transfer Objects (DTOs), and centralized error handling.

---

## 🛠 Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** H2 (In-memory)
* **Build Tool:** Maven
* **Testing:** Postman

---

## 🏗 Architectural Overview

The project follows a strict **Layered Architecture** to ensure separation of concerns and ease of testing.



* **Controller Layer:** Manages HTTP requests/responses and maps endpoints.
* **Service Layer:** Encapsulates business logic and coordinates between repositories.
* **Repository Layer:** Interface-driven data access using Spring Data JPA.
* **Model Layer:** Includes both JPA Entities (Database schema) and DTOs (API contract).

### Key Design Principles
* **DTO Pattern:** Decouples the API contract from the database schema.
* **Global Exception Handling:** Centralized error management using `@RestControllerAdvice`.
* **Validation:** JSR-303 Bean Validation for data integrity.

---

## 🚀 Features

* **User Management:** Create and retrieve user profiles with validated inputs.
* **Task Management:** Full lifecycle (CRUD) of tasks linked to specific users.
* **Relational Mapping:** `One-to-Many` relationship between Users and Tasks.
* **Pagination:** Optimized data fetching using `Pageable`.

---

## 🔗 API Documentation

### User Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/users` | Register a new user |
| `GET` | `/users/{id}` | Retrieve user profile by ID |
| `GET` | `/users/{id}/tasks` | Get all tasks for a specific user |

### Task Endpoints
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/tasks` | Create a task (requires `userId`) |
| `GET` | `/tasks/{id}` | Get task details |
| `DELETE` | `/tasks/{id}` | Remove a task |

---

## 🚦 Getting Started

### Prerequisites
* JDK 17 or higher
* Maven 3.6+

### Installation & Run
1. **Clone the repository:**
   ```bash
   git clone [https://github.com/yourusername/task-manager-backend.git](https://github.com/yourusername/task-manager-backend.git)
Navigate to the project folder:

Bash

cd task-manager-backend
Run the application:

Bash

./mvnw spring-boot:run
The server will start at http://localhost:8080.

🧠 Technical Learnings
Data Integrity: Catching invalid data using @NotBlank and @Email.

JPA Relationships: Managing parent-child entity lifecycles.

API Scalability: Implementing pagination to handle large datasets.

Author: Suryansh Dwivedi
