package com.mapper;

import com.model.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task> {
        @Override
        public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
            Task task = new Task();
            task.setId(rs.getString("id"));
            task.setTitle(rs.getString("title"));
            task.setCompleted(rs.getBoolean("completed"));
            task.setTimestamp(rs.getString("createdtime"));
            return task;
        }
}
