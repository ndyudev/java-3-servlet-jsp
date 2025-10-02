package ndyudev.lab4.cau2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class C2Caculate
 */
@WebServlet({ "/lab4/cau1/calculate/add", "/lab4/cau1/calculate/sub" })
public class C2Caculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public C2Caculate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message", "Nhập số và chọn phép tính!");
		request.getRequestDispatcher("/view/lab4/cau2/Calculate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		String path = request.getServletPath();
		if (path.endsWith("/add")) {
			double c = Double.valueOf(a) + Double.valueOf(b);
			request.setAttribute("message", a + " + " + b + " = " + c);
		} else {
			double c = Double.valueOf(a) - Double.valueOf(b);
			request.setAttribute("message", a + " - " + b + " = " + c);
		}

		request.getRequestDispatcher("/view/lab4/cau2/Calculate.jsp").forward(request, response);
	}

}
