package com.bh08.javaquizapp.model;

public class Answer {
	private int id;
	private String answer;
	private boolean correct;

	public Answer(String answer, boolean correct) {
		this.answer = answer;
		this.correct = correct;
	}

	public Answer(int id, String answer, boolean correct) {
		this(answer, correct);
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public boolean isCorrect() {
		return correct;
	}
}
