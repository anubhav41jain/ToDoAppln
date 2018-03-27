package com.service;

import com.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoService {
    public int addTask(Task task);
    public int removeTask(Task task);
    public int updateTask(Task task);
    public List<Task> getActiveTasks();
    public List<Task> getCompletedTasks();
    public List<Task> getAllTasks();
    public Task getTaskByTitle(String title);
}
