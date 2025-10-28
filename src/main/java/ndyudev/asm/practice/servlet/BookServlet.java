package ndyudev.asm.practice.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;
import ndyudev.asm.practice.dao.BookDAO;
import ndyudev.asm.practice.dao.impl.BookDAOImpl;
import ndyudev.asm.practice.entity.Book;

@WebServlet({
    "/practice/book/index",
    "/practice/book/edit/*",
    "/practice/book/create",
    "/practice/book/update",
    "/practice/book/delete",
    "/practice/book/reset",
    "/practice/book/search"
})
public class BookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🧩 Lấy data từ form
        Book form = new Book();
        String message = "";
        try {
            BeanUtils.populate(form, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 🧩 Tạo DAO
        BookDAO dao = new BookDAOImpl();
        String path = request.getServletPath();

        if (path.startsWith("/practice/book/edit/")) {
            String id = request.getPathInfo().substring(1);
            if (id != null && !id.isEmpty()) {
                Optional<Book> opt = dao.findById(id);
                form = opt.orElse(new Book());
            }
        } else if (path.equals("/practice/book/create")) {
            try {
                dao.insert(form);
                form = new Book();
                message = "✅ Thêm mới thành công!";
            } catch (RuntimeException e) {
                message = "⚠️ Trùng khóa chính!";
            }
        } else if (path.equals("/practice/book/update")) {
            dao.update(form);
            message = "✏️ Cập nhật thành công!";
        } else if (path.equals("/practice/book/delete")) {
            if (form.getIdBook() != null && !form.getIdBook().isEmpty()) {
                dao.delete(form.getIdBook());
            }
            form = new Book();
            message = "🗑 Xóa thành công!";
        } else if (path.equals("/practice/book/reset")) {
            form = new Book();
        } else if (path.equals("/practice/book/search")) {
            String keyword = request.getParameter("kw");
            List<Book> list = dao.searchByKeyword(keyword);
            request.setAttribute("list", list);
            request.setAttribute("item", form);
            request.getRequestDispatcher("/view/asm/practice/BookManagement.jsp").forward(request, response);
            return;
        }

        // 🧩 Load danh sách
        List<Book> list = dao.findAll();

        // 🧩 Gửi data ra view
        request.setAttribute("item", form);
        request.setAttribute("list", list);
        request.setAttribute("message", message);

        // 🧩 Forward đến JSP
        request.getRequestDispatcher("/view/asm/practice/BookManagement.jsp").forward(request, response);
    }
}