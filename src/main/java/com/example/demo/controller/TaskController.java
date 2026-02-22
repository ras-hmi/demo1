package com.example.demo.controller;

import com.example.demo.model.Status;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController @RequestMapping("/tasks")
public class TaskController {
        private final TaskService service;
        public TaskController(TaskService service) {

            this.service = service;
        }
        @PostMapping
        public Task create(@RequestBody Task task)
        {
            return service.createTask(task);
        }

        @GetMapping("/{id}")
        public Task get(@PathVariable Long id) {

            return service.getTask(id);
        }

        @PutMapping("/{id}")
        public Task update(@PathVariable Long id, @RequestBody Task task)
        {
            return service.updateStatus(id, task.getStatus());
        }
        @DeleteMapping("/{id}")
        public Task deleteTask(@PathVariable Long id) {

            return service.deleteTask(id);
        }
        @GetMapping
        public List<Task> getAllTask() {

            return service.getAllTasks();
        }
        @PatchMapping("/{id}/status")
        public Task updateStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest request) {
            return service.updateStatus(id, request.getStatus());
        }
}
class StatusUpdateRequest {
    private Status status;
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}

