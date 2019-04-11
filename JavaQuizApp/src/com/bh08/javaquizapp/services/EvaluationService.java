package com.bh08.javaquizapp.services;

import java.util.List;

import com.bh08.javaquizapp.daos.TopListDAO;
import com.bh08.javaquizapp.model.User;

public class EvaluationService {
	
	private TopListDAO topListDao;
	private static EvaluationService instance;
	
	private EvaluationService() {
		topListDao = new TopListDAO();
	}
	
	public static EvaluationService getInstance() {
		if (instance == null) {
			instance = new EvaluationService();
		}
		return instance;
	}	
	
	public List<String> getTopList() {
		return topListDao.getTopList();
	}
	
	public void setNewHighScore(User user, int score) {
		topListDao.setNewHighScore(user, score);
	}
}
