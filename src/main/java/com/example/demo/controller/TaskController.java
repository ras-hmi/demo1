package com.example.demo.controller;

public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createTask(task));
    }
}
