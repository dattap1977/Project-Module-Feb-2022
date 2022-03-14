package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.Constants;
import com.scaler.taskmanager.tasks.CreateTaskRequestBody;
import com.scaler.taskmanager.tasks.TaskEntity;
import com.scaler.taskmanager.tasks.TasksService;
import com.scaler.taskmanager.tasks.UpdateTaskRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/notes")
@RestController
public class NotesController {
    @Autowired
    private NotesService notesService;

    @Autowired
    private TasksService tasksService;

    //public TasksController(TasksService tasksService) {
      //  this.tasksService = tasksService;
    //}

    @GetMapping("")
    ResponseEntity<List<NoteEntity>> getAllNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @GetMapping("/{id}/notes")
    ResponseEntity<List<NoteEntity>> getAllNotesOfATask(@PathVariable(value = "id") Long id) {
        TaskEntity taskEntity = tasksService.findTask(id);
       List<NoteEntity> listofNotes =  notesService.findByTask(taskEntity);
       return ResponseEntity.ok( listofNotes);
    }
//    @PostMapping("")
//    ResponseEntity<TaskEntity> createTask(@RequestBody CreateTaskRequestBody body) {
//
//        TaskEntity savedTask = tasksService.addNewTask(body.getName(),body.getDueDate(),body.getStatus());
//
//        return ResponseEntity.created(
//                URI.create(Constants.BASE_URL + "/tasks/" + savedTask.id)
//        ).body(savedTask);
//    }
//
//    @PatchMapping("/{id}")
//    ResponseEntity<TaskEntity> updateTask(@PathVariable(value = "id") Long id,@RequestBody UpdateTaskRequestBody body ){
//        TaskEntity updatedTask  = tasksService.updateTask(id,body.getName(),body.getDueDate(),body.getStatus());
//        return ResponseEntity.created(URI.create(Constants.BASE_URL + "/tasks/" + id)).body(updatedTask);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    boolean deleteTask(@PathVariable(value = "id") Long id){
//        boolean deleteTask = tasksService.deleteTask(id);
//        return deleteTask;
//    }
}
