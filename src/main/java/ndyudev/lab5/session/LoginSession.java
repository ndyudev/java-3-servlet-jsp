package ndyudev.lab5.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/lab5/login/cookie")
public class LoginSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginSession() {
        super();
    }

    // Khi load lại trang login.jsp, servlet này sẽ chạy trước để đọc cookie
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    String encoded = cookie.getValue();
                    byte[] bytes = Base64.getDecoder().decode(encoded);
                    String[] userInfo = new String(bytes).split(",");
                    if (userInfo.length == 2) {
                        request.setAttribute("username", userInfo[0]);
                        request.setAttribute("password", userInfo[1]);
                    }
                }
            }
        }
        request.getRequestDispatcher("/view/lab5/cookie/LoginCookie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember-me");

        if ("ndyudev".equalsIgnoreCase(username) && "227".equals(password)) {
            request.setAttribute("message", "Login successfully!");
            request.getSession().setAttribute("username", username);

            // Nếu có tick "Remember me" → lưu cookie
            if (remember != null) {
                byte[] bytes = (username + "," + password).getBytes();
                String userInfo = Base64.getEncoder().encodeToString(bytes);
                Cookie cookie = new Cookie("user", userInfo);
                cookie.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
                cookie.setPath("/"); // hiệu lực toàn ứng dụng
                response.addCookie(cookie);
            }
        } else {
            request.setAttribute("message", "Invalid login info!");
        }

        // Quay lại trang login.jsp
        request.getRequestDispatcher("/view/lab5/cookie/LoginCookie.jsp").forward(request, response);
    }
}
