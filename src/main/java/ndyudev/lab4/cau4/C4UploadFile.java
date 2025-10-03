package ndyudev.lab4.cau4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/lab4/cau4/uploadfile")
@MultipartConfig
public class C4UploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public C4UploadFile() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/lab4/cau4/UploadFile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Part part = request.getPart("photo");
        String path = request.getServletContext().getRealPath("images");

        File f = new File(path);
        if (!f.exists()) f.mkdir();

        String filename = part.getSubmittedFileName();
        part.write(path + File.separator + filename);

        // Gộp thành URL để JSP hiển thị
        String fileUrl = request.getContextPath() + "/images/" + filename;

        request.setAttribute("filename", filename);
        request.setAttribute("path", path);
        request.setAttribute("fileUrl", fileUrl);

        request.getRequestDispatcher("/view/lab4/cau4/UploadFile.jsp").forward(request, response);
    }
}
