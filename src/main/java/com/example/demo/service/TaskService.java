package com.example.demo.service;

import com.example.demo.model.Status;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import java.time.Instant;
import java.util.List;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // 1️⃣ Create Task
    public Task createTask(Task task) {
        task.setStatus(Status.PENDING);
        task.setDeleted(false);
        task.setCreatedAt(Instant.now());
        task.setUpdatedAt(Instant.now());

        return repository.save(task);
    }

    // 2️⃣ Get Task by ID
    public Task getTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (task.isDeleted()) {
            throw new RuntimeException("Task not found with id: " + id);
        }

        return task;
    }

    // 3️⃣ List Active Tasks
    public List<Task> getAllTasks() {
        return repository.findAll()
                .stream()
                .filter(t -> !t.isDeleted())
                .toList();
    }

    // 4️⃣ Soft Delete
    public Task deleteTask(Long id) {
        Task task = getTask(id);
        task.setDeleted(true);
        task.setUpdatedAt(Instant.now());
        return repository.save(task);
    }
    public Task updateStatus(Long id, Status newStatus) {

        Task task = getTask(id);

        validateTransition(task.getStatus(), newStatus);

        task.setStatus(newStatus);
        task.setUpdatedAt(Instant.now());

        return repository.save(task);
    }
    private void validateTransition(Status current, Status next) {

        if (current == Status.PENDING &&
                (next == Status.IN_PROGRESS || next == Status.CANCELLED)) {
            return;
        }

        if (current == Status.IN_PROGRESS &&
                (next == Status.COMPLETED || next == Status.CANCELLED)) {
            return;
        }

        throw new RuntimeException(
                "Cannot transition from " + current + " to " + next
        );
    }
}
