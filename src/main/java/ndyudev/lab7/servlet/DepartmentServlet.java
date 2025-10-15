package ndyudev.lab7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import ndyudev.lab7.dao.DepartmentDAO;
import ndyudev.lab7.dao.impl.DepartmentDAOImpl;
import ndyudev.lab7.entity.Department;

@WebServlet({ 
	"/department/index", 
	"/department/edit/*", 
	"/department/create", 
	"/department/update",
	"/department/delete", 
	"/department/reset" 
})
public class DepartmentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lay thong tin tren form luu vao bien form
		Department form = new Department();
		String message = "";
		try {
			BeanUtils.populate(form, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		// tao doi tuong truy cap table Department
		DepartmentDAO dao = new DepartmentDAOImpl();
		
		String path = request.getServletPath();
		if (path.contains("edit")) {
			String id = request.getPathInfo().substring(1);
			form = dao.findById(id);
		} else if (path.contains("create")) {
			try {
				dao.create(form);
				form = new Department();
			} catch (RuntimeException e) {
				message = "Trùng khóa chính";
			}
		} else if (path.contains("update")) {
			dao.update(form);
		} else if (path.contains("delete")) {
			dao.deleteById(form.getId());
			form = new Department();
		} else {
			form = new Department();
		}
		
		request.setAttribute("item", form);
		List<Department> list = dao.findAll();
		request.setAttribute("list", list);
		request.setAttribute("message",message);
		
		//request.getRequestDispatcher("/views/Department.jsp").forward(request, response);
		//request.getRequestDispatcher("/views/Department.jsp").forward(request, response);
		
		request.setAttribute("page", "Department.jsp");
		request.getRequestDispatcher("/view/lab7/Admin.jsp").forward(request, response);
	}
}

