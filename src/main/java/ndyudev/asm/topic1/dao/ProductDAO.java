package ndyudev.asm.topic1.dao;

import java.util.List;

import ndyudev.asm.topic1.entity.Product;

public interface ProductDAO {
	/**Truy vấn tất cả*/
	List<Product> findAll();
	/** Tìm sách theo loại */
	List<Product> findByLoai(String loaiSp);
	/**Truy vấn theo mã*/
	Product findById(String id);
	/**Thêm mới*/
	void create(Product item);
	/**Cập nhật*/
	void update(Product item);
	/**Xóa theo mã*/
	void deleteById(String id);
}
