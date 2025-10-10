package ndyudev.lab5.mail;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/send-mail-2")
@MultipartConfig
public class MailerFile2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/lab5/mail/MailFileForm2.jsp").forward(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String subject = req.getParameter("subject");
		String body = req.getParameter("body");

		// Lấy file upload
		Part filePart = req.getPart("file");
		String fileName = filePart.getSubmittedFileName();

		// Lưu file tạm trong thư mục upload
		String uploadPath = getServletContext().getRealPath("/uploads");
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		String filePath = uploadPath + File.separator + fileName;
		filePart.write(filePath);

		// Gửi mail
		int result = MailerFile2.send(from, to, subject, body, filePath);
		
		req.getRequestDispatcher("/view/lab5/mail/MailFileForm2.jsp").forward(req, resp);
	}
}
