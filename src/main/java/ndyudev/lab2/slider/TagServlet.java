package ndyudev.lab2.slider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Lab2/Tags")
public class TagServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TagServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String ageParam = request.getParameter("age");

        // Kiểm tra null tránh lỗi
        int age = 0;
        if (ageParam != null && !ageParam.isEmpty()) {
            age = Integer.parseInt(ageParam);
        }

        // Truyền sang JSP
        request.setAttribute("name", name);
        request.setAttribute("age", age);

        request.getRequestDispatcher("/view/lab2/Tags.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
