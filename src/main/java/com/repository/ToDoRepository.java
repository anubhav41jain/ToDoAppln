package com.repository;

import com.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository {
    public int addTask(Task task);
    public int removeTask(Task task);
    public int updateTask(Task task);
    public List<Task> getActiveTasks();
    public List<Task> getCompletedTasks();
    public List<Task> getAllTasks();
    public Task getTaskByTitle(String title);
}
