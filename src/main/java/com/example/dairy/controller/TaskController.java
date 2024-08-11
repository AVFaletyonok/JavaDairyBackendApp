package com.example.dairy.controller;

import com.example.dairy.model.Task;
import com.example.dairy.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskByID(@PathVariable(name = "id") long id) {
        if (taskRepository.findById(id).isPresent())
            return taskRepository.findById(id).get();
        else
            return null;
    }

    @GetMapping("/tasks")
    public Iterable<Task> getTaskAll() {
        return taskRepository.findAll();
    }
//    public String sayHello() {
//        return "Hello!";
//    }
}
