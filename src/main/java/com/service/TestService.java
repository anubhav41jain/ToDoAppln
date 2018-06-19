package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Question;

@Service
public interface TestService {
	public int addQuestion(Question question);
    public int removeQuestion(Question question);
    public int updateQuestion(Question question);
    public List<Question> getQuesBySubject(String className, String sub);
    public List<Question> getQuesBySubAndChap(String className, String sub, String chapter);
    public List<Question> getQuesBySubAndChapAndMarks(String className, String sub, String chapter, String marks);
    public List<Question> getQuesBySubAndMarks(String className, String sub, String marks);
    public List<Question> getAllQuestions();
    public Question getQuestionById(String id);
    public List<String> getAllClasses();
    public List<String> getAllSubjects(String className);
    public List<String> getAllChapters(String className, String sub);
}
