package com.service;

import com.model.Task;
import com.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public int addTask(Task task) {
        return toDoRepository.addTask(task);
    }

    @Override
    public int removeTask(Task task) {
        return toDoRepository.removeTask(task);
    }

    @Override
    public List<Task> getActiveTasks(){
        return toDoRepository.getActiveTasks();
    };

    @Override
    public List<Task> getCompletedTasks(){
        return toDoRepository.getAllTasks();
    };

    @Override
    public List<Task> getAllTasks() {
        return toDoRepository.getAllTasks();
    }

    @Override
    public int updateTask(Task task){return toDoRepository.updateTask(task);};

    @Override
    public Task getTaskByTitle(String title) {
        return toDoRepository.getTaskByTitle(title);
    }
}
