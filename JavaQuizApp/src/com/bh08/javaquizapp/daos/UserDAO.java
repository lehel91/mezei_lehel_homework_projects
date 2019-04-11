package com.bh08.javaquizapp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.bh08.javaquizapp.database.DBManager;
import com.bh08.javaquizapp.exceptions.AuthenticationException;
import com.bh08.javaquizapp.model.User;

public class UserDAO {

	private final static String USER_QUERY = "SELECT * FROM users WHERE username = ? AND password = ?";

	public Optional<User> getUserByUserNameAndPassword(String userName, String password) {

		try {
			
			PreparedStatement prepStatement = DBManager.getDbManager().getConnection().prepareStatement(USER_QUERY);
			System.out.println(USER_QUERY);
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);

			ResultSet searchResult;

			searchResult = prepStatement.executeQuery();

			User user = new User();

			if (searchResult.next()) {

				user.setUserName(searchResult.getString("username"));
				user.setPassword(searchResult.getString("password"));

				return Optional.of(user);

			} else {
				return Optional.empty();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Optional.empty();

		}

	}
}
