package com.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Question;
import com.service.TestService;

@RestController
@RequestMapping("/test/api")
public class TestRestController {

	@Autowired
	private TestService testService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity<?> add(@RequestBody Question question) {
		int val = testService.addQuestion(question);
		return new ResponseEntity<>(question, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
	public ResponseEntity<?> getAllQuestionsByClassAndSub(@PathParam(value = "className") String className,
														  @PathParam(value = "subjectName") String subjectName) {
		List<Question> quesList = testService.getQuesBySubject(className,subjectName);
		return new ResponseEntity<>(quesList, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAllClasses", method = RequestMethod.GET)
	public ResponseEntity<?> allClasses() {
		List<String> classes = testService.getAllClasses();
		return new ResponseEntity<>(classes, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAllSubjects", method = RequestMethod.GET)
	public ResponseEntity<?> allSubjects(@PathParam(value = "className") String className) {
		List<String> subjects = testService.getAllSubjects(className);
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAllChapters", method = RequestMethod.GET)
	public ResponseEntity<?> allChapters(@PathParam(value = "className") String className,
			@PathParam(value = "subjectName") String subjectName) {
		List<String> chapters = testService.getAllChapters(className, subjectName);
		return new ResponseEntity<>(chapters, HttpStatus.OK);
	}
}
