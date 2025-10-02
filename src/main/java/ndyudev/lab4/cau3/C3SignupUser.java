package ndyudev.lab4.cau3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Servlet implementation class C3SignupUser
 */
@WebServlet("/lab4/cau3/signup")
public class C3SignupUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C3SignupUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/lab4/cau3/SignupUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String gender = request.getParameter("gender");
		String married = request.getParameter("family");
		String country = request.getParameter("country");
		String[] hobby = request.getParameterValues("hobbies");
		String note = request.getParameter("note");
		
		System.out.println("Username: : " + username);
		System.out.println("Hobbies " + Arrays.toString(hobby));
		System.out.println("Gender: " + gender);
		System.out.println("Country: " + country);
		System.out.println("Tình trạng gia đình : " + (married != null ? "Đã có gia đình" : "Chưa có gia đình"));
		
		request.setAttribute("name", username);
		request.setAttribute("gender", gender);
		request.setAttribute("married", married);
		request.setAttribute("country", country);
		request.setAttribute("note", note);
		request.setAttribute("hobbies", hobby);
		request.getRequestDispatcher("/view/lab4/cau3/SignupUser.jsp").forward(request, response);
	}

}
