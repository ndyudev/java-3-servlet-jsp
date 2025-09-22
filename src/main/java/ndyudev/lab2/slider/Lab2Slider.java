package ndyudev.lab2.slider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab2.entity.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Lab2Slider
 */
@WebServlet("/lab2/slider")
public class Lab2Slider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab2Slider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullName = "Chau Nhat Duy";
		int age = 18;
		boolean gioitinh = true;
		
		List<Student> list = new ArrayList<>();
		
		request.setAttribute("username", fullName);
		request.setAttribute("message", "Welcome to JSP + Servlet demo! 🚀");
		request.setAttribute("age", age);
		request.setAttribute("gioitinh", gioitinh);
		request.setAttribute("list", list);

        // forward tới index.jsp
		request.getRequestDispatcher("/view/lab2/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
