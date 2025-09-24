package ndyudev.lab2.cau4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/lab2/cau4/form/update2")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		User bean = new User();
		bean.setFullname("Châu Nhật Duy");
		bean.setGender(true);
		bean.setCountry("VN");
		request.setAttribute("user", bean);
		request.setAttribute("editabled", true);
		request.getRequestDispatcher("/view/lab2/form-cau3-2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		System.out.println(fullname);

		// nếu muốn cập nhật lại User bean
		User bean = new User();
		bean.setFullname(fullname);
		bean.setGender(Boolean.parseBoolean(request.getParameter("gender")));
		bean.setCountry(request.getParameter("country"));

		request.setAttribute("user", bean);
		request.setAttribute("editabled", false);

		request.getRequestDispatcher("/view/lab2/form-cau3-2.jsp").forward(request, response);
	}

}
