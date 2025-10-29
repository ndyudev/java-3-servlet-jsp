package ndyudev.asm.topic2.dao;

import java.util.List;

import ndyudev.asm.topic2.entity.Student;

public interface StudentDAO {
	/**Truy vấn tất cả*/
	List<Student> findAll();
	/** Tìm sách theo loại */
	List<Student> findByKhoa(String khoa);
	/**Truy vấn theo mã*/
	Student findById(String id);
	/**Thêm mới*/
	void create(Student item);
	/**Cập nhật*/
	void update(Student item);
	/**Xóa theo mã*/
	void deleteById(String id);
}
