package com.bh08.javaquizapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bh08.javaquizapp.daos.QuestionDAO;
import com.bh08.javaquizapp.model.Question;
import com.bh08.javaquizapp.model.User;
import com.bh08.javaquizapp.exceptions.AuthenticationException;
import com.bh08.javaquizapp.exceptions.DataAccessException;
import com.bh08.javaquizapp.daos.UserDAO;

public class DBManager {
	private static DBManager dbManager = null;

	private Connection connection;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "JAVA_QUIZ";
	private static final String PASSWORD = "javaquiz";

	private DBManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public static DBManager getDbManager() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}
