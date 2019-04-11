package com.bh08.javaquizapp.services;

import java.util.Optional;

import com.bh08.javaquizapp.daos.UserDAO;
import com.bh08.javaquizapp.exceptions.AuthenticationException;
import com.bh08.javaquizapp.exceptions.DataAccessException;
import com.bh08.javaquizapp.model.User;


public class LoginService {
	
	private UserDAO userDao;

	private static LoginService instance;
	
	private LoginService() {
		userDao = new UserDAO();
	}
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}	
	
	public User login(String username, String password) throws AuthenticationException {

		Optional<User> result = userDao.getUserByUserNameAndPassword(username, password);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new AuthenticationException("Login failed: username or password invalid.");
		}

	}
}
