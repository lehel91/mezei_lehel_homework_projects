package com.bh08.javaquizapp.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bh08.javaquizapp.database.DBManager;
import com.bh08.javaquizapp.model.Answer;
import com.bh08.javaquizapp.model.Question;

public class QuestionDAO {

	private static final String QUESTIONS_QUERY = "SELECT q.question_id, "
			+ "q.question, "
			+ "a.answer_id, "
			+ "a.question_id, "
			+ "a.answer, "
			+ "a.IsCorrect "
			+ "FROM answers a LEFT JOIN questions q "
			+ "ON q.question_id = a.question_id "
			+ "ORDER BY q.question_id, a.answer_id";
	
	public QuestionDAO() {

	}

	/**
	 * @return the questionList
	 */
	public List<Question> getQuestionList() {
		try {

			List<Question> questionList = new ArrayList<>();
			
			Statement statement = DBManager.getDbManager().getConnection().createStatement();
			ResultSet rs;
			rs = statement.executeQuery(QUESTIONS_QUERY);

			int actualQuestionId = 0;

			while (rs.next()) {
				int id = rs.getInt("question_id");

				if (actualQuestionId != id) {
					actualQuestionId = id;
					Question question = new Question(id, rs.getString("question"));
					questionList.add(question);
				}

				if ("Y".equals(rs.getString("IsCorrect"))) {
					Answer answer = new Answer(rs.getInt("answer_id"), rs.getString("answer"), true);
					questionList.get(rs.getInt("question_id") - 1).addAnAnswer(answer);
				} else {
					Answer answer = new Answer(rs.getInt("answer_id"), rs.getString("answer"), false);
					questionList.get(rs.getInt("question_id") - 1).addAnAnswer(answer);
				}
			}

			return questionList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
