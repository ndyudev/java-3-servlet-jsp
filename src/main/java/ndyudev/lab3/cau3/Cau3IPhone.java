package ndyudev.lab3.cau3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;

/**
 * Servlet implementation class Cau3IPhone
 */
@WebServlet("/lab3/cau3/iphone")
public class Cau3IPhone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cau3IPhone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> iphone = new HashMap<>();
		
		iphone.put("name", "Iphone 17 Pro Max");
		iphone.put("price", 12345.678);
		iphone.put("date", new Date());
		
		request.setAttribute("iphone", iphone);
		
		request.getRequestDispatcher("/view/lab3/cau3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
