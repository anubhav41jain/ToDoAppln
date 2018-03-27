package com.controller;

import com.model.Task;
import com.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/api")
public class ToDoRestController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<?> add(@RequestBody Task task) {
        task.setCompleted(false);
        int val=toDoService.addTask(task);
        Task updatedtask=null;
        String title=task.getTitle();
        if(val==1)
            updatedtask=toDoService.getTaskByTitle(title);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@RequestBody Task task) {
        toDoService.removeTask(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "/getActiveTasks", method = RequestMethod.GET)
    public ResponseEntity<?> getActiveTasks() {
        List<Task> list=toDoService.getActiveTasks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCompletedTasks", method = RequestMethod.GET)
    public ResponseEntity<?> getCompletedTasks() {
        List<Task> list=toDoService.getCompletedTasks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.PUT)
    public ResponseEntity<?> status(@RequestBody Task task) {
        int val=toDoService.updateTask(task);
        Task updatedtask=null;
        if(val==1)
            updatedtask=toDoService.getTaskByTitle(task.getTitle());
        return new ResponseEntity<>(updatedtask, HttpStatus.OK);
    }

    @RequestMapping(value = "/getTaskByTitle", method = RequestMethod.POST)
    public ResponseEntity<?> getTaskByTitle(@RequestBody String title) {
        Task task=toDoService.getTaskByTitle(title);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllTasks", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTasks() {
        List<Task> list=toDoService.getAllTasks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/")
    public int checkTodoAPI() {
        return 1;
    }
}