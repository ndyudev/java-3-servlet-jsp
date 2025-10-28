package ndyudev.asm.practice.dao.impl;

import ndyudev.asm.practice.dao.CategoryDAO;
import ndyudev.asm.practice.entity.Category;
import ndyudev.asm.practice.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String INSERT_SQL = "INSERT INTO Category (idCategory, nameCategory) VALUES (?, ?)";
    private static final String UPDATE_SQL = "UPDATE Category SET nameCategory = ? WHERE idCategory = ?";
    private static final String DELETE_SQL = "DELETE FROM Category WHERE idCategory = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Category";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM Category WHERE idCategory = ?";

    @Override
    public boolean insert(Category entity) {
        try {
            return JdbcHelper.executeUpdate(INSERT_SQL,
                    entity.getIdCategory(),
                    entity.getNameCategory()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Category entity) {
        try {
            return JdbcHelper.executeUpdate(UPDATE_SQL,
                    entity.getNameCategory(),
                    entity.getIdCategory()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            return JdbcHelper.executeUpdate(DELETE_SQL, id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Category> findById(String id) {
        try (ResultSet rs = JdbcHelper.executeQuery(SELECT_BY_ID_SQL, id)) {
            if (rs.next()) return Optional.of(map(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(SELECT_ALL_SQL)) {
            while (rs.next()) list.add(map(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private Category map(ResultSet rs) throws SQLException {
        return new Category(
                rs.getString("idCategory"),
                rs.getString("nameCategory")
        );
    }
}