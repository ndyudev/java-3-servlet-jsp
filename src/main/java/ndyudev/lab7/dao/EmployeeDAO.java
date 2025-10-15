package ndyudev.lab7.dao;

import java.util.List;

import ndyudev.lab7.entity.Employee;

public interface EmployeeDAO {
		/**Truy vấn tất cả*/
		List<Employee> findAll();
		/**Truy vấn theo mã*/
		Employee findById(String id);
		/**Thêm mới*/
		void create(Employee item);
		/**Cập nhật*/
		void update(Employee item);
		/**Xóa theo mã*/
		void deleteById(String id);
}
