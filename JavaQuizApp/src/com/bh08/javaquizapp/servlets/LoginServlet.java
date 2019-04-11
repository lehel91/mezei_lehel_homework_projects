package com.bh08.javaquizapp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bh08.javaquizapp.daos.QuestionDAO;
import com.bh08.javaquizapp.daos.UserDAO;
import com.bh08.javaquizapp.database.DBManager;
import com.bh08.javaquizapp.exceptions.AuthenticationException;
import com.bh08.javaquizapp.model.Question;
import com.bh08.javaquizapp.model.User;
import com.bh08.javaquizapp.services.LoginService;
import com.bh08.javaquizapp.services.QuizService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("POST request received");

		try {
			User user = LoginService.getInstance().login(userName, password);
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			session.setAttribute("loginTime", new Date());

			List<Question> questionList = QuizService.getInstance().getQuestionList();
			request.setAttribute("questionList", questionList);

			request.getRequestDispatcher("quiz.jsp").forward(request, response);

			System.out.println(userName + " has logged in.");

		} catch (AuthenticationException e1) {
			e1.printStackTrace();

			try {
				response.getWriter().append("Authentication failure!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException | ServletException ex) {
			ex.printStackTrace();
		}

	}
}
