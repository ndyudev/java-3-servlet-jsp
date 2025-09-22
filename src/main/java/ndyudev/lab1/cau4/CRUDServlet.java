package ndyudev.lab1.cau4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/crud/create", "/crud/update", "/crud/delete", "/crud/edit/*" })
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println("URI: " + uri);
		String ctx = req.getContextPath();
		String path = uri.substring(ctx.length());
		String message;
		if (uri.contains("/crud/create")) {
			message = "Bạn vừa gọi CREATE!";
		} else if (uri.contains("/crud/update")) {
			message = "Bạn vừa gọi UPDATE!";
		} else if (uri.contains("/crud/delete")) {
			message = "Bạn vừa gọi DELETE!";
		} else if (uri.contains("/crud/edit/")) {
			String id = path.substring("/crud/edit/".length()); // lấy phần sau edit/
			message = "Bạn vừa gọi EDIT với ixd = " + id;
		} else {
			message = "Không biết yêu cầu gì!";
		}

		// In ra màn hình
//        resp.setContentType("application/json;charset=UTF-8");

		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<h2>" + "Hello Servlet" + "</h2>");
	}
}
