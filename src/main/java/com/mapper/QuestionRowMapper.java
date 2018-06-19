package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Question;

public class QuestionRowMapper implements RowMapper<Question> {
        @Override
        public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Question question = new Question();
        	question.setAns(rs.getString("ans"));
        	question.setChapter(rs.getString("chapter"));
        	question.setClassName(rs.getString("className"));
        	question.setQues(rs.getString("ques"));
        	question.setSubject(rs.getString("subject"));
        	question.setMarks(rs.getInt("marks"));
            return question;
        }
}
