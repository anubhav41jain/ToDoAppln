package com.model;

public class Question {
	int id;
	String ques;
	String className;
	String subject;
	int marks;
	String chapter;
	String ans;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ques
	 */
	public String getQues() {
		return ques;
	}
	
	/**
	 * @param ques the ques to set
	 */
	public void setQues(String ques) {
		this.ques = ques;
	}
	
	/**
	 * @return the className
	 */
	
	public String getClassName() {
		return className;
	}
	
	/**
	 * @param className the className to set
	 */
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	/**
	 * @return the subject
	 */
	
	public String getSubject() {
		return subject;
	}
	
	/**
	 * @param subject the subject to set
	 */
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * @return the marks
	 */
	
	public int getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}
	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return chapter;
	}
	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	/**
	 * @return the ans
	 */
	public String getAns() {
		return ans;
	}

	/**
	 * @param ans the ans to set
	 */
	public void setAns(String ans) {
		this.ans = ans;
	}

}
