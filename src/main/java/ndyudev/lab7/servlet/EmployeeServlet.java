package ndyudev.lab7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import ndyudev.lab7.dao.*;
import ndyudev.lab7.dao.impl.DepartmentDAOImpl;
import ndyudev.lab7.dao.impl.EmployeeDAOImpl;
import ndyudev.lab7.entity.Department;
import ndyudev.lab7.entity.Employee;

@MultipartConfig()
@WebServlet({
    "/employee/index",
    "/employee/edit/*",
    "/employee/create",
    "/employee/update",
    "/employee/delete",
    "/employee/reset",
    "/employee/upload"
})
public class EmployeeServlet extends HttpServlet {
    
    Employee form = new Employee();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO dao = new EmployeeDAOImpl();
        DepartmentDAO dpdao = new DepartmentDAOImpl();

        String path = request.getServletPath();
        DateTimeConverter dtc = new DateConverter(new Date());
        dtc.setPattern("MM/dd/yy");
        ConvertUtils.register(dtc, Date.class);

        if (path.contains("edit")) {
            String id = request.getPathInfo().substring(1);
            form = dao.findById(id);

        } else if (path.contains("create")) {
            try {
                BeanUtils.populate(form, request.getParameterMap());
                dao.create(form);
                form = new Employee();
                request.setAttribute("message", "✅ Employee created successfully!");
            } catch (Exception e) {
                request.setAttribute("message", "⚠️ Duplicate ID or invalid data!");
            }

        } else if (path.contains("update")) {
            try {
                BeanUtils.populate(form, request.getParameterMap());
                dao.update(form);
                request.setAttribute("message", "✅ Employee updated!");
            } catch (Exception e) {
                request.setAttribute("message", "❌ Update failed!");
            }

        } else if (path.contains("delete")) {
            dao.deleteById(form.getId());
            form = new Employee();
            request.setAttribute("message", "🗑️ Employee deleted!");

        } else if (path.contains("upload")) {
            Part part = request.getPart("photo");
            try {
                BeanUtils.populate(form, request.getParameterMap());
                if (part != null && part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
                    form.setPhoto(part.getSubmittedFileName());
                    upload(request, part, "images1");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            form = new Employee();
        }

        request.setAttribute("item", form);
        request.setAttribute("list", dao.findAll());
        request.setAttribute("listDepartments", dpdao.findAll());

        // Forward
        request.setAttribute("page", "Employee.jsp");
        request.getRequestDispatcher("/view/lab7/Admin.jsp").forward(request, response);
    }

    public void upload(HttpServletRequest request, Part part, String folder) {
        try {
            String path = request.getServletContext().getRealPath("/" + folder);
            File dir = new File(path);
            if (!dir.exists()) dir.mkdir();
            part.write(path + File.separator + part.getSubmittedFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
