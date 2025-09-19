package ndyudev.lab1.cau5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lab1/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Gán attribute để JSP hiển thị
        request.setAttribute("username", "Dyu 😎");
        request.setAttribute("message", "Chào mừng đến với Bài 5: Servlet + JSP 🚀");

        // Forward đến JSP
        request.getRequestDispatcher("/view/lab1/index.jsp").forward(request, response);
    }
}
