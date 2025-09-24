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
@WebServlet("/lab2/cau4/form/update")
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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setFullname("Châu Nhật Duy | cau 4");
		user.setGender(true);
		user.setCountry("VN");

		request.setAttribute("user", user);
		request.setAttribute("editabled", true);

		request.getRequestDispatcher("/view/lab2/form-cau4.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		System.out.println(fullname);

		request.getRequestDispatcher("/view/lab2/form-cau4.jsp").forward(request, response);
	}

}
