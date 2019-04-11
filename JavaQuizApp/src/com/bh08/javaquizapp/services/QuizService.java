package com.bh08.javaquizapp.services;

import java.util.List;
import java.util.Optional;

import com.bh08.javaquizapp.daos.QuestionDAO;
import com.bh08.javaquizapp.daos.UserDAO;
import com.bh08.javaquizapp.exceptions.AuthenticationException;
import com.bh08.javaquizapp.model.Question;
import com.bh08.javaquizapp.model.User;

public class QuizService {
	private QuestionDAO questionDao;

	private static QuizService instance;
	
	private QuizService() {
		questionDao = new QuestionDAO();
	}
	
	public static QuizService getInstance() {
		if (instance == null) {
			instance = new QuizService();
		}
		return instance;
	}	
	
	public List<Question> getQuestionList() {

		return questionDao.getQuestionList();

	}
}
