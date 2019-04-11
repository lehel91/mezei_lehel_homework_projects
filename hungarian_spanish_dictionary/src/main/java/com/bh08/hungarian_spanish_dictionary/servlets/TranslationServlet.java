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
 * Servlet implementation class TranslationServlet
 */

@WebServlet("/translation")
public class TranslationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DictionaryService dictionaryService = new DictionaryService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TranslationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String word = (String) request.getParameter("word");

		Word translatedWord = null;
		if (dictionaryService.findByHungarianWord(word).isPresent()) {
			translatedWord = dictionaryService.findByHungarianWord(word).get();
		}

		request.setAttribute("translatedWord", translatedWord);
		request.getRequestDispatcher("translation.jsp").forward(request, response);
		System.out.println("doGetTranslation");
		System.out.println(word);

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
