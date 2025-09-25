package ndyudev.lab3.cau5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Servlet implementation class Cau5Product
 */
@WebServlet("/lab3/cau5/product")
public class Cau5Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cau5Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> productList = new ArrayList<>();

		productList.add(new Product("pd01", "Iphone 17 AIR", 15.554));
		productList.add(new Product("pd02", "Iphone 17 Pro", 17.64));
		productList.add(new Product("pd03", "Iphone 17 Pro Max", 29.94));

		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/view/lab3/cau5.jsp").forward(request, response);

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
