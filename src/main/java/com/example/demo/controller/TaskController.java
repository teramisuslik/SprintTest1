package com.example.demo.controller;
import com.example.demo.model.Task;

import com.example.demo.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController

public class TaskController {



    @Autowired

    private TaskRepository taskRepository;



    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tesks")
    public Iterable<Task> getAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/tesks/{id}")
    public Task getById(@PathVariable Long id){
        return taskRepository.findById(id).orElse(null);
    }

    @PutMapping("/tasks/{id}")
    public Task update(@PathVariable Long id,
                       @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete (@PathVariable Long id){
        taskRepository.deleteById(id);
    }

    @PatchMapping("/tasks/{id}")
    public void patchMethod(@PathVariable Long id,
                            @RequestBody Task task){
        if (task.isDone()){
            taskRepository.markAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void patchMetod(@PathVariable Long id,
                           @RequestBody Task task){
        taskRepository.markAsDone(id);
    }
}
