package ndyudev.lab1.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CRUDServlet
 */
@WebServlet({ "/crud/create", "/crud/update", "/crud/delete", "/crud/edit/*" })
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("URI: " + uri);
		super.service(req, resp); // Cho Tomcat gọi tiếp doGet/doPost
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String method = request.getMethod();
		System.out.println(method);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Lấy dữ liệu từ form
		String fullname = req.getParameter("fullname");
		String ageStr = req.getParameter("age");
		int age = ageStr != null && !ageStr.isEmpty() ? Integer.parseInt(ageStr) : 0;

		System.out.println("POST data:");
		System.out.println("Fullname = " + fullname);
		System.out.println("Age = " + age);

		// Gửi response về browser
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h2>Data Received</h2>");
		resp.getWriter().println("<p>Fullname: " + fullname + "</p>");
		resp.getWriter().println("<p>Age: " + age + "</p>");
	}

}
