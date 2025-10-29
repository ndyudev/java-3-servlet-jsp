package ndyudev.asm.topic2.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ndyudev.asm.topic2.entity.Student;
import ndyudev.asm.topic2.dao.StudentDAO;
import ndyudev.asm.topic2.utils.JdbcHelper;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() {
        String sql = "SELECT * FROM Student";
        try {
            List<Student> entities = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student();
                s.setMasv(rs.getString("masv"));
                s.setHoten(rs.getString("hoten"));
                s.setNamsinh(rs.getInt("namsinh"));
                s.setGioitinh(rs.getBoolean("gioitinh"));
                s.setMakhoa(rs.getString("makhoa"));
                entities.add(s);
            }
            return entities;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(String id) {
        String sql = "SELECT * FROM Student WHERE masv=?";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, id);
            if (rs.next()) {
                return new Student(
                    rs.getString("masv"),
                    rs.getString("hoten"),
                    rs.getInt("namsinh"),
                    rs.getBoolean("gioitinh"),
                    rs.getString("makhoa")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void create(Student s) {
        String sql = "INSERT INTO Student (masv, hoten, namsinh, gioitinh, makhoa) VALUES (?, ?, ?, ?, ?)";
        try {
            JdbcHelper.executeUpdate(sql, s.getMasv(), s.getHoten(), s.getNamsinh(), s.getGioitinh(), s.getMakhoa());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student s) {
        String sql = "UPDATE Student SET hoten=?, namsinh=?, gioitinh=?, makhoa=? WHERE masv=?";
        try {
            JdbcHelper.executeUpdate(sql, s.getHoten(), s.getNamsinh(), s.getGioitinh(), s.getMakhoa(), s.getMasv());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findByKhoa(String khoa) {
        String sql = "SELECT * FROM Student WHERE makhoa = ?";
        List<Student> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, khoa);
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("masv"),
                    rs.getString("hoten"),
                    rs.getInt("namsinh"),
                    rs.getBoolean("gioitinh"),
                    rs.getString("makhoa")
                );
                list.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "DELETE FROM Student WHERE masv=?";
        try {
            JdbcHelper.executeUpdate(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
