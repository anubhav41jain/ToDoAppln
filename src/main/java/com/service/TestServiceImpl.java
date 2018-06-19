package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Question;
import com.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestRepository testRepository;

	@Override
	public int addQuestion(Question question) {
		return testRepository.addQuestion(question);
	}

	@Override
	public int removeQuestion(Question question)  {
		return testRepository.removeQuestion(question);
	}

	@Override
	public int updateQuestion(Question question)  {
		return testRepository.updateQuestion(question);
	}

	@Override
	public List<Question> getQuesBySubject(String className, String sub)  {
		return testRepository.getQuesBySubject(className,sub);
	}

	@Override
	public List<Question> getQuesBySubAndChap(String className, String sub, String chapter)  {
		return testRepository.getQuesBySubAndChap(className,sub,chapter);
	}

	@Override
	public List<Question> getQuesBySubAndChapAndMarks(String className, String sub, String chapter, String marks)  {
		return testRepository.getQuesBySubAndChapAndMarks(className,sub,chapter,marks);
	}

	@Override
	public List<Question> getQuesBySubAndMarks(String className, String sub, String marks)  {
		return testRepository.getQuesBySubAndMarks(className,sub,marks);
	}

	@Override
	public List<Question> getAllQuestions()  {
		return testRepository.getAllQuestions();
	}

	@Override
	public Question getQuestionById(String id)  {
		return testRepository.getQuestionById(id);
	}

	@Override
	public List<String> getAllClasses() {
		return testRepository.getAllClasses();
	}

	@Override
	public List<String> getAllSubjects(String className) {
		return testRepository.getAllSubjects(className);
	}

	@Override
	public List<String> getAllChapters(String className, String sub) {
		return testRepository.getAllChapters(className, sub);
	}

}
