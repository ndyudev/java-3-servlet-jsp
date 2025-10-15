package ndyudev.lab7.dao;

import java.util.List;

import ndyudev.lab7.entity.Department;

public interface DepartmentDAO {
		/**Truy vấn tất cả*/
		List<Department> findAll();
		/**Truy vấn theo mã*/
		Department findById(String id);
		/**Thêm mới*/
		void create(Department item);
		/**Cập nhật*/
		void update(Department item);
		/**Xóa theo mã*/
		void deleteById(String id);
}
