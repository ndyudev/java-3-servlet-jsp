package ndyudev.lab1.cau3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Cau2
 */
@WebServlet("/lab1/cau3")
public class UrlInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UrlInfoServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuffer URL = request.getRequestURL();
		String URI = request.getRequestURI();
		String queryString = request.getQueryString();
		String ServletPath = request.getContextPath();
		String pathInfo = request.getPathInfo();
		String method = request.getMethod();

		response.getWriter().println("URL:" + URI + "\nURI:" + URI + "\nQuery String:" + queryString + "\nServlet Path:"
				+ ServletPath + "\nPath Info:" + pathInfo + "\nMethod:" + method);
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
