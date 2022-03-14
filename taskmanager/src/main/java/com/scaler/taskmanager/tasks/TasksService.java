package com.scaler.taskmanager.tasks;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TasksService {
    private TasksRepository tasksRepo;

    public TasksService(TasksRepository tasksRepo) {
        this.tasksRepo = tasksRepo;
    }

    List<TaskEntity> getAllTasks() {
        return tasksRepo.findAll();
    }

    TaskEntity addNewTask(String taskName, LocalDate dueDate, Boolean status) {
        TaskEntity task = new TaskEntity(taskName);
        TaskEntity savedTask = tasksRepo.save(task);
        return savedTask;
    }

    TaskEntity updateTask(Long id,String taskName, LocalDate dueDate, String status) {
        TaskEntity task = tasksRepo.getById(id);
        task.setName(taskName);
        task.setDueDate(dueDate);
        if (status.equals("true"))
        task.setStatus(new Boolean(true));
        else
        task.setStatus(new Boolean(false));
        TaskEntity savedTask = tasksRepo.save(task);
        return savedTask;
    }

    public boolean deleteTask(Long id) {
        tasksRepo.deleteById(id);
        return true;
    }

    public TaskEntity findTask(Long id) {
        return tasksRepo.getById(id);
    }
}
