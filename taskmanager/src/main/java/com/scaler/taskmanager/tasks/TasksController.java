package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TasksController {
    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskEntity>> getAllTasks() {
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    @PostMapping("")
    ResponseEntity<TaskEntity> createTask(@RequestBody CreateTaskRequestBody body) {

        TaskEntity savedTask = tasksService.addNewTask(body.getName(),body.getDueDate(),body.getStatus());

        return ResponseEntity.created(
                URI.create(Constants.BASE_URL + "/tasks/" + savedTask.id)
        ).body(savedTask);
    }

    @PatchMapping("/{id}")
    ResponseEntity<TaskEntity> updateTask(@PathVariable(value = "id") Long id,@RequestBody UpdateTaskRequestBody body ){
        TaskEntity updatedTask  = tasksService.updateTask(id,body.getName(),body.getDueDate(),body.getStatus());
        return ResponseEntity.created(URI.create(Constants.BASE_URL + "/tasks/" + id)).body(updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    boolean deleteTask(@PathVariable(value = "id") Long id){
        boolean deleteTask = tasksService.deleteTask(id);
        return deleteTask;
    }
}
