package ndyudev.lab7.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ndyudev.lab7.dao.DepartmentDAO;
import ndyudev.lab7.entity.Department;
import ndyudev.lab7.util.Jdbc;


public class DepartmentDAOImpl implements DepartmentDAO {
	@Override
	public List<Department> findAll() {
		String sql = "SELECT * FROM Department";
		try {
			List<Department> entities = new ArrayList<>();
			Object[] values = {};
			ResultSet resultSet = Jdbc.executeQuery(sql, values);
			while (resultSet.next()) {
				Department entity = new Department();
				entity.setId(resultSet.getString("Id"));
				entity.setName(resultSet.getString("Name"));
				entity.setDescription(resultSet.getString("Description"));
				entities.add(entity);
			}
			return entities;
		} catch (Exception e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Department findById(String id) {
		String sql = "SELECT * FROM Department WHERE Id=?";
		try {
			Object[] values = { id };
			ResultSet resultSet = Jdbc.executeQuery(sql, values);
			if (resultSet.next()) {
				Department entity = new Department();
				entity.setId(resultSet.getString("Id"));
				entity.setName(resultSet.getString("Name"));
				entity.setDescription(resultSet.getString("Description"));
				return entity;
			}
		} catch (Exception e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
		}
		// throw new RuntimeException("Not found");
		return null;
	}

	@Override
	public void create(Department entity) {
		String sql = "INSERT INTO Department(Id, Name, Description) VALUES(?, ?, ?)";
		try {
			Object[] values = { 
				entity.getId(), 
				entity.getName(), 
				entity.getDescription() 
			};
			Jdbc.executeUpdate(sql, values);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Department entity) {
		String sql = "UPDATE Department SET Name=?, Description=? WHERE Id=?";
		try {
			Object[] values = { 
				entity.getName(), 
				entity.getDescription(), 
				entity.getId() 
			};
			Jdbc.executeUpdate(sql, values);
		} catch (Exception e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteById(String id) {
		String sql = "DELETE FROM Department WHERE Id=?";
		try {
			Object[] values = { id };
			Jdbc.executeUpdate(sql, values);
		} catch (Exception e) {
			//throw new RuntimeException(e);
			System.out.println(e.getMessage());
		}
	}
}
