package ndyudev.lab2.slider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Thue
 */
@WebServlet("/lab2/thue")
public class Thue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Thue() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("fullName");
		String moneyParam = request.getParameter("money"); // lấy về dưới dạng String
		Double money = 0.0;
		Double thue = 0.0;

		if (moneyParam != null && !moneyParam.isEmpty()) {
			try {
				money = Double.parseDouble(moneyParam);
			} catch (NumberFormatException e) {
				money = 0.0; // fallback nếu nhập sai
			}
		}

		if (fullName != null && !fullName.isEmpty()) {
			if (money > 10000000) {
				thue = money * 0.1;
			}
			request.setAttribute("fullName", fullName);
			request.setAttribute("tax", thue);
		}

		// Forward sang JSP
		request.getRequestDispatcher("/view/lab2/Thue.jsp").forward(request, response);
	}
}
