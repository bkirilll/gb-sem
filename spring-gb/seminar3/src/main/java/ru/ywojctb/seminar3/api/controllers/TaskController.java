package ru.ywojctb.seminar3.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ywojctb.seminar3.api.services.DataProcessingService;
import ru.ywojctb.seminar3.store.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<UserEntity> sortUserByAge() {
        return dataProcessingService.sortUserByAge(dataProcessingService.getAllUsers());
    }

    @GetMapping("/filter/{age}")
    public List<UserEntity> filterUsersByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUserByAge(dataProcessingService.getAllUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAvgUserAge(dataProcessingService.getAllUsers());
    }

}
