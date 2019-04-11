package com.bh08.javaquizapp.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private int id;
	private String question;
	private List<Answer> answers;
	
	public Question(String question, List<Answer> answers) {
		this.question = question;
		this.answers = answers;
	}
	
	public Question(int id, String question) {
		this.id = id;
		this.question = question;
		this.answers = new ArrayList<>();
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public void addAnAnswer(Answer answer) {
		answers.add(answer);
	}

}
