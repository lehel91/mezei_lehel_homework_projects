package com.bh08.javaquizapp.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bh08.javaquizapp.database.DBManager;
import com.bh08.javaquizapp.model.User;

public class TopListDAO {
	
	private static final String TOPLIST_QUERY = "SELECT username, highest_score " + 
			"FROM users " + 
			"WHERE highest_score > 0 " + 
			"ORDER BY highest_score DESC";
	
	private static final String USERS_HIGHEST_SCORE = "SELECT highest_score " +
			"FROM users " +
			"WHERE username = ?";
	
	private static final String UPDATE_HIGHEST_SCORE = "UPDATE users " +
			"SET highest_score = ? " + 
			"WHERE username = ?";
	
	public TopListDAO() {

	}

	/**
	 * @return the questionList
	 */
	public List<String> getTopList() {
		try {
			
			List<String> topList = new ArrayList<>();
			Statement statement = DBManager.getDbManager().getConnection().createStatement();
			ResultSet rs;
			rs = statement.executeQuery(TOPLIST_QUERY);
			
			int i = 1;
			while (rs.next()) {
				topList.add(i + ". " + rs.getString(1) + ", " + rs.getInt(2) + " pont.\n");
				i++;
			}
			return topList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void setNewHighScore(User user, int score) {
		if (score > askForPriorHighestScore(user)) {
			try {
				PreparedStatement preparedStatement = DBManager.getDbManager()
						.getConnection().prepareStatement(UPDATE_HIGHEST_SCORE);
				
				preparedStatement.setInt(1, score);
				preparedStatement.setString(2, user.getUserName());
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int askForPriorHighestScore(User user) {
		try {
			PreparedStatement preparedStatement = DBManager.getDbManager()
					.getConnection().prepareStatement(USERS_HIGHEST_SCORE);
			
			preparedStatement.setString(1, user.getUserName());
			ResultSet rs = preparedStatement.executeQuery();
			
			int actualHighestScore = 0;
			
			if (rs.next()) {
				actualHighestScore = rs.getInt(1);
			}
			
			return actualHighestScore;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
