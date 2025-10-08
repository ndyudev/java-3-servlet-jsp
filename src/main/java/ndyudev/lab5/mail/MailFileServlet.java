package ndyudev.lab5.mail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/lab5/mail/sendmailfile")
@MultipartConfig
public class MailFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/lab5/mail/MailFileForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");
        Part filePart = request.getPart("file");

        int result = MailerFile.sendWithFile(from, to, subject, body, filePart);

        if (result < 0)
            request.setAttribute("message", "❌ Send mail error!");
        else
            request.setAttribute("message", "✅ Send mail success!");

        request.getRequestDispatcher("/view/lab5/mail/MailFileForm.jsp").forward(request, response);
    }
}
