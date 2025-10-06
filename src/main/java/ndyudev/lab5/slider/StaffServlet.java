package ndyudev.lab5.slider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.io.IOException;

@WebServlet("/lab5/slider/staff")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // mở form nhập staff
        request.getRequestDispatcher("/view/lab5/slider/Staff.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Staff staff = new Staff();
            // Populate dữ liệu từ request
            
            // 🔧 Fix lỗi convert Date
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPattern("yyyy-MM-dd"); // format giống input HTML
            ConvertUtils.register(dateConverter, java.util.Date.class);

 
            BeanUtils.populate(staff, request.getParameterMap());

            // Gửi sang trang hiển thị
            request.setAttribute("staff", staff);
            request.getRequestDispatcher("/view/lab5/slider/StaffInfo.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
