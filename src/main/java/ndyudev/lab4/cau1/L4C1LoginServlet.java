package ndyudev.lab4.cau1;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab4/cau1/account/login")
public class L4C1LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("message", "Nhập tài khoản và mật khẩu của bạn!");
        request.getRequestDispatcher("/view/lab4/cau1/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("ndyudev".equalsIgnoreCase(username) && "227184".equals(password)) {
        	request.setAttribute("message", "Đăng nhập thành công!");
        } else {
        	request.setAttribute("message", "Tài khoản hoặc mật khẩu sai!");
        }

        request.getRequestDispatcher("/view/lab4/cau1/Login.jsp").forward(request, response);
    }
}
