package com.bh08.hungarian_spanish_dictionary.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh08.hungarian_spanish_dictionary.model.Word;
import com.bh08.hungarian_spanish_dictionary.services.DictionaryService;

/**
 * Servlet implementation class DictionaryServlet
 */

@WebServlet("/dictionary")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DictionaryService dictionaryService = new DictionaryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DictionaryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String wordToTranslate = request.getParameter("word");

		

		request.setAttribute("translatedWord", wordToTranslate);
		System.out.println("doGetDictionary");
		request.getRequestDispatcher("translation").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
