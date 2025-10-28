package ndyudev.asm.practice.dao;

import java.util.List;

import ndyudev.asm.practice.entity.Book;

public interface BookDAO extends BaseDAO<Book, String> {
    /**
     * Lấy danh sách sách theo mã loại
     * @param idCategory mã loại sách (FK)
     * @return danh sách Book thuộc category đó
     */
    List<Book> findByCategory(String idCategory);
    
    /**
     * Tìm sách theo keyword (mã loại hoặc tên sách)
     * @param keyword từ khóa tìm kiếm
     * @return danh sách Book match
     */
    List<Book> searchByKeyword(String keyword);
}