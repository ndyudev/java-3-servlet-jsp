package ndyudev.lab4.slider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

/**
 * Servlet implementation class uploadfile
 */
@MultipartConfig // servlet xử lý file phải có annotation này
@WebServlet("/lab4/slider/uploadfile")
public class uploadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public uploadfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("file");

		// Lấy đường dẫn vật lý của thư mục images trong project đã deploy
		String uploadPath = request.getServletContext().getRealPath("images");
		File dir = new File(uploadPath);
		if (!dir.exists())
			dir.mkdir();

		// Lấy tên file
		String filename = part.getSubmittedFileName();

		// Ghi file vào thư mục images
		part.write(uploadPath + File.separator + filename);

		// Truyền đường dẫn relative cho JSP
		request.setAttribute("path", "images/" + filename);

		request.getRequestDispatcher("/view/lab4/uploadfile.jsp").forward(request, response);
	}

}
