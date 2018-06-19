package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mapper.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.model.Question;

@Repository
public class TestRepositoryImpl implements TestRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addQuestion(Question question) {
        return jdbcTemplate.update("insert into question(className,subject,chapter,marks,ques,ans) " + "values(?, ?, ?, ?, ?, ?)",
                new Object[]{question.getClassName(), question.getSubject(), question.getChapter(), question.getMarks(), question.getQues(), question.getAns()
                });
    }

    @Override
    public int removeQuestion(Question question) {
        return jdbcTemplate.update("delete from question where className=? and subject=? and ques=? and marks=? and chapter=? and ans=?",new Object[] {
                question.getClassName(),question.getSubject(),question.getQues(),question.getMarks(),question.getMarks(),question.getAns()});
    }

    @Override
    public int updateQuestion(Question question) {
        return jdbcTemplate.update("update question set className=?,subject=?,ques=?,marks=?,chapter=?,ans=?",new Object[] {
                question.getClassName(),question.getSubject(),question.getQues(),question.getMarks(),question.getMarks(),question.getAns()});
    }

    @Override
    public List<Question> getQuesBySubject(String className, String sub) {
        return jdbcTemplate.query("select * from question where className=? and subject=?",new Object[] {
                className,sub}, new QuestionRowMapper());
    }

    @Override
    public List<Question> getQuesBySubAndChap(String className, String sub, String chapter) {
        return jdbcTemplate.query("select * from question where className=? and subject=? and chapter=?",new Object[] {
                className,sub,chapter}, new QuestionRowMapper());
    }

    @Override
    public List<Question> getQuesBySubAndChapAndMarks(String className, String sub, String chapter, String marks) {
        return jdbcTemplate.query("select * from question where className=? and subject=? and chapter=? and marks=?",new Object[] {
                className,sub,chapter,marks}, new QuestionRowMapper());
    }

    @Override
    public List<Question> getQuesBySubAndMarks(String className, String sub, String marks) {
        return jdbcTemplate.query("select * from question where className=? and subject=? and marks=?",new Object[] {
                className,sub,marks}, new QuestionRowMapper());
    }

    @Override
    public List<Question> getAllQuestions() {
        return jdbcTemplate.query("select * from question", new QuestionRowMapper());
    }

    @Override
    public Question getQuestionById(String id) {
        return jdbcTemplate.queryForObject("select * from question where id=?",new Object[] {
                Integer.parseInt(id)}, new QuestionRowMapper());
    }

    @Override
    public List<String> getAllClasses() {
        List<Map<String, Object>> classesList = new ArrayList<Map<String, Object>>();
        List<String> classes = new ArrayList<String>();
        classesList = jdbcTemplate.queryForList("select * from classes");
        for (Map<String, Object> map : classesList) {
            for (String o : map.keySet())
                if (o.equalsIgnoreCase("className"))
                    classes.add(map.get(o).toString());
        }
        return classes;
    }

    @Override
    public List<String> getAllSubjects(String className) {
        List<Map<String, Object>> subjectList = new ArrayList<Map<String, Object>>();
        List<String> subject = new ArrayList<String>();
        subjectList = jdbcTemplate.queryForList(
                "select * from subjects s left outer join classes c on s.class_id=c.class_id where c.className='"
                        + className + "'");
        for (Map<String, Object> map : subjectList) {
            for (String o : map.keySet())
                if (o.equalsIgnoreCase("subjectName"))
                    subject.add(map.get(o).toString());
        }
        return subject;
    }

    @Override
    public List<String> getAllChapters(String className, String sub) {
        List<Map<String, Object>> subjectList = new ArrayList<Map<String, Object>>();
        List<String> subject = new ArrayList<String>();
        subjectList = jdbcTemplate.queryForList(
                "select * from chapters chap left outer join classes c on chap.class_id=c.class_id where c.className='"
                        + className + "' and chap.subjectName='" + sub + "'");
        for (Map<String, Object> map : subjectList) {
            for (String o : map.keySet())
                if (o.equalsIgnoreCase("chapterName"))
                    subject.add(map.get(o).toString());
        }
        return subject;
    }

}
