# Development Notes

## Overall Approach
I implemented the Task Scheduling API using Spring Boot with a layered architecture:
- Controller → Service → Repository
- Enforced status transitions
- Soft-delete handling

Initialize Spring Boot project with web and JPA dependencies

Add Task entity with fields and enums

Configure H2 in-memory database and enable console

Create TaskRepository interface using Spring Data JPA

Implement TaskService with CRUD and status transition logic

Add TaskController with REST endpoints

Add global exception handler with consistent error response format

Add validation for title length and priority enum

Preload sample tasks using data.sql

Add unit tests for TaskService and TaskController

Write DEVELOPMENT_NOTES.md with design decisions and improvements
