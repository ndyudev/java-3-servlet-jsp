package ndyudev.asm.topic1.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.topic1.entity.Product;
import ndyudev.asm.topic1.dao.ProductDAO;
import ndyudev.asm.topic1.dao.impl.ProductDAOImpl;

@WebServlet({
    "/asm/topic1/index",
    "/asm/topic1/edit/*",
    "/asm/topic1/create",
    "/asm/topic1/update",
    "/asm/topic1/delete",
    "/asm/topic1/reset",
    "/asm/topic1/search"
})
public class ProductServlet extends HttpServlet {
	 @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Product form = new Product();
	        try {
	            BeanUtils.populate(form, req.getParameterMap());
	        } catch (IllegalAccessException | InvocationTargetException e) {
	            e.printStackTrace();
	        }

	        ProductDAO dao = new ProductDAOImpl();
	        String path = req.getServletPath();

	        if (path.contains("edit")) {
	            String id = req.getPathInfo().substring(1);
	            form = dao.findById(id);
	            req.setAttribute("list", dao.findAll());

	        } else if (path.contains("create")) {
	            dao.create(form);
	            form = new Product();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("update")) {
	            dao.update(form);
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("delete")) {
	            dao.deleteById(form.getMaSp());
	            form = new Product();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("reset")) {
	            form = new Product();
	            req.setAttribute("list", dao.findAll()); 

	        } else if (path.contains("search")) {
	            String loai = req.getParameter("loaiLoc");
	            try {
	            	if (loai != null && !loai.trim().isEmpty() && !loai.equalsIgnoreCase("Tất cả")) { 
	                    List<Product> list = dao.findByLoai(loai.trim());
	                    req.setAttribute("list", list);
	                    form = new Product();
	                } else {
	                    req.setAttribute("list", dao.findAll());
	                }
	            } catch (Exception e) {
	                req.setAttribute("message", "Không tìm thấy loại: " + loai);
	                req.setAttribute("list", dao.findAll());
	                form = new Product();
	            }

	        } else {
	            form = new Product();
	            req.setAttribute("list", dao.findAll());
	        }

	        req.setAttribute("item", form);
	        req.getRequestDispatcher("/view/asm/topic1/ProductPage.jsp").forward(req, resp);
	    }
}
