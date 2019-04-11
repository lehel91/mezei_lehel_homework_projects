package com.bh08.javaquizapp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh08.javaquizapp.model.Answer;
import com.bh08.javaquizapp.model.User;
import com.bh08.javaquizapp.services.EvaluationService;
import com.bh08.javaquizapp.services.QuizService;

/**
 * Servlet implementation class EvaluateServlet
 */
@WebServlet("/evaluation")
public class EvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EvaluationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//itt kezeld majd, hogy lehet nullPointer is (ha nincsenek valaszok)
		String[] answersByUser = (String[]) request.getAttribute("answersByUser");
		int[] answersByUserConvertedToInt = new int[answersByUser.length];
		for (int i = 0; i < answersByUser.length; i++) {
			answersByUserConvertedToInt[i] = 
					Integer.parseInt(answersByUser[i].substring(0, answersByUser[i].length() - 1));
		}
		
		List<Boolean> answerValues = new ArrayList<>();
		
		for (int i = 0; i < QuizService.getInstance().getQuestionList().size(); i++) {
			for (Answer answer : QuizService.getInstance().getQuestionList().get(i).getAnswers()) {
				if (answer.isCorrect()) {
					answerValues.add(true);
				} else {
					answerValues.add(false);
				}
			}
		}
		
		int score = 0;
		for (int answerId : answersByUserConvertedToInt) {
			if (answerValues.get(answerId - 1).equals(true)) {
				score++;
			} else {
				score--;
			}
		}

		request.setAttribute("score", score);
		User user = (User) request.getSession().getAttribute("user");
		setNewHighScore(user, score);
		request.setAttribute("toplist", EvaluationService.getInstance().getTopList());
		request.getRequestDispatcher("evaluation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void setNewHighScore(User user, int score) {
		
		EvaluationService.getInstance().setNewHighScore(user, score);
	}

}
