package ndyudev.asm.practice.dao.impl;

import ndyudev.asm.practice.dao.BookDAO;
import ndyudev.asm.practice.entity.Book;
import ndyudev.asm.practice.utils.JdbcHelper;
import java.sql.*;
import java.util.*;

public class BookDAOImpl implements BookDAO {
    private final String INSERT = "INSERT INTO Book (idBook, nameBook, priceBook, yearBook, idCategory) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE Book SET nameBook=?, priceBook=?, yearBook=?, idCategory=? WHERE idBook=?";
    private final String DELETE = "DELETE FROM Book WHERE idBook=?";
    private final String SELECT_ALL = "SELECT * FROM Book";
    private final String SELECT_BY_ID = "SELECT * FROM Book WHERE idBook=?";
    private final String SELECT_BY_CATEGORY = "SELECT * FROM Book WHERE idCategory=?";
    private final String SEARCH_KEYWORD = "SELECT * FROM Book WHERE idCategory LIKE ? OR nameBook LIKE ?";

    @Override
    public boolean insert(Book entity) {
        try {
            return JdbcHelper.executeUpdate(INSERT,
                    entity.getIdBook(),
                    entity.getNameBook(),
                    entity.getPriceBook(),
                    entity.getYearBook(),
                    entity.getIdCategory()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book entity) {
        try {
            return JdbcHelper.executeUpdate(UPDATE,
                    entity.getNameBook(),
                    entity.getPriceBook(),
                    entity.getYearBook(),
                    entity.getIdCategory(),
                    entity.getIdBook()) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            return JdbcHelper.executeUpdate(DELETE, id) > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> findById(String id) {
        try (ResultSet rs = JdbcHelper.executeQuery(SELECT_BY_ID, id)) {
            if (rs.next()) {
                return Optional.of(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Book> findByCategory(String idCategory) {
        List<Book> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(SELECT_BY_CATEGORY, idCategory)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Book> searchByKeyword(String keyword) {
        List<Book> list = new ArrayList<>();
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll();
        }
        String searchTerm = "%" + keyword.trim() + "%";
        try (ResultSet rs = JdbcHelper.executeQuery(SEARCH_KEYWORD, searchTerm, searchTerm)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private Book map(ResultSet rs) throws SQLException {
        return new Book(
                rs.getString("idBook"),
                rs.getString("nameBook"),
                rs.getDouble("priceBook"),
                rs.getInt("yearBook"),
                rs.getString("idCategory")
        );
    }
}