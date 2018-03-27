package com.repository;

import com.mapper.TaskRowMapper;
import com.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addTask(Task task) {
        return jdbcTemplate.update("insert into todo (title, completed, createdtime) " + "values(?,  ?, ?)",
                new Object[] {
                        task.getTitle(), task.isCompleted(), new Date()
                });
    }

    @Override
    public Task getTaskByTitle(String title) {
        return jdbcTemplate.queryForObject("select * from todo where title=?",new Object[] {
                title}, new TaskRowMapper());
    }

    @Override
    public int removeTask(Task task) {
        return jdbcTemplate.update("delete from todo " + "where title=? and completed=?",
                new Object[] {
                        task.getTitle(), task.isCompleted()
                });
    }

    @Override
    public List<Task> getActiveTasks(){
        return jdbcTemplate.query("select * from todo where completed=false",
                new TaskRowMapper());
    };

    @Override
    public List<Task> getCompletedTasks(){
        return jdbcTemplate.query("select * from todo where completed=true",
                new TaskRowMapper());
    };

    public int updateTask(Task task) {
        return jdbcTemplate.update("update todo set completed=? " + "where title=?",
                new Object[] {
                        task.isCompleted(), task.getTitle()
                });
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query("select * from todo",
                new TaskRowMapper());
    }

}
