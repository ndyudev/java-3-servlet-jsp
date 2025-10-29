package ndyudev.asm.topic2.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.topic2.entity.Student;
import ndyudev.asm.topic2.dao.StudentDAO;
import ndyudev.asm.topic2.dao.impl.StudentDAOImpl;

@WebServlet({
    "/asm/topic2/index",
    "/asm/topic2/edit/*",
    "/asm/topic2/create",
    "/asm/topic2/update",
    "/asm/topic2/delete",
    "/asm/topic2/reset",
    "/asm/topic2/search"
})
public class StudentServlet extends HttpServlet {
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Student form = new Student();
	        try {
	            BeanUtils.populate(form, req.getParameterMap());
	        } catch (IllegalAccessException | InvocationTargetException e) {
	            e.printStackTrace();
	        }

	        StudentDAO dao = new StudentDAOImpl();
	        String path = req.getServletPath();

	        if (path.contains("edit")) {
	            String id = req.getPathInfo().substring(1);
	            form = dao.findById(id);
	            req.setAttribute("list", dao.findAll());

	        } else if (path.contains("create")) {
	            dao.create(form);
	            form = new Student();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("update")) {
	            dao.update(form);
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("delete")) {
	            dao.deleteById(form.getMasv());
	            form = new Student();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("reset")) {
	            form = new Student();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("search")) {
	            String loai = req.getParameter("keyword");
	            try {
	            	if (loai != null && !loai.trim().isEmpty() && !loai.equalsIgnoreCase("Tất cả")) { 
	                    List<Student> list = dao.findByKhoa(loai.trim());
	                    req.setAttribute("list", list);
	                    form = new Student();
	                } else {
	                    req.setAttribute("list", dao.findAll());
	                }
	            } catch (Exception e) {
	                req.setAttribute("message", "Không tìm thấy khoa: " + loai);
	                req.setAttribute("list", dao.findAll());
	                form = new Student();
	            }

	        } else {
	            form = new Student();
	            req.setAttribute("list", dao.findAll());

	        }
	        
	        req.setAttribute("item", form);
	        req.getRequestDispatcher("/view/asm/topic2/StudentPage.jsp").forward(req, resp);
	    }
}
