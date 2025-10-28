package ndyudev.asm.practice.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T, ID> {
    // Create
    boolean insert(T entity);

    // Update
    boolean update(T entity);

    // Delete
    boolean delete(ID id);

    // Find by ID
    Optional<T> findById(ID id);

    // Find all
    List<T> findAll();
}