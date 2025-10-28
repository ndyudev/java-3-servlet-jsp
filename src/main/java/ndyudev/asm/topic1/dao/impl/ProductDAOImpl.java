package ndyudev.asm.topic1.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ndyudev.asm.topic1.entity.Product;
import ndyudev.asm.topic1.dao.ProductDAO;
import ndyudev.asm.topic1.utils.JdbcHelper;

public class ProductDAOImpl implements ProductDAO {
	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM sanpham";
		try {
			List<Product> entities = new ArrayList<>();
			Object[] values = {};
			ResultSet resultSet = JdbcHelper.executeQuery(sql, values);
			while (resultSet.next()) {
				Product entity = new Product();
				entity.setMaSp(resultSet.getString("masp"));        
		        entity.setTenSp(resultSet.getString("tensp"));      
		        entity.setGia(resultSet.getDouble("gia"));    
		        entity.setLoaiSp(resultSet.getString("loaisp"));
				entities.add(entity);
			}
			return entities;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
		public Product findById(String id) {
			String sql = "SELECT * FROM sanpham WHERE masp=?";
			try {
				Object[] values = { id };
				ResultSet resultSet = JdbcHelper.executeQuery(sql, values);
				if (resultSet.next()) {
					Product entity = new Product();
					entity.setMaSp(resultSet.getString("masp"));        
			        entity.setTenSp(resultSet.getString("tensp"));      
			        entity.setGia(resultSet.getDouble("gia"));    
			        entity.setLoaiSp(resultSet.getString("loaisp"));
					return entity;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException("Not found");
		}
	
	@Override
		public void create(Product entity) {
			String sql = "INSERT INTO sanpham (masp, tensp, gia, loaisp) VALUES (?, ?, ?, ?)";
			try {
				Object[] values = {
						entity.getMaSp(),      
						entity.getTenSp(),    
						entity.getGia(),       
						entity.getLoaiSp()
				};
				JdbcHelper.executeUpdate(sql, values);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	
	@Override
		public void update(Product entity) {
		String sql = "UPDATE sanpham SET tensp=?, gia=?, loaisp=? WHERE masp=?";
		try {
			Object[] values = {
					entity.getTenSp(),      
					entity.getGia(),        
					entity.getLoaiSp(),     
					entity.getMaSp()
			};
			JdbcHelper.executeUpdate(sql, values);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<Product> findByLoai(String loaiSp) {
	    String sql = "SELECT * FROM sanpham WHERE loaisp = ?";
	    List<Product> list = new ArrayList<>();
	    try {
	        ResultSet rs = JdbcHelper.executeQuery(sql, loaiSp);
	        while (rs.next()) {
	        	Product s = new Product();
	        	s.setMaSp(rs.getString("masp"));    
	            s.setTenSp(rs.getString("tensp"));  
	            s.setGia(rs.getDouble("gia"));      
	            s.setLoaiSp(rs.getString("loaisp"));
	            list.add(s);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	    return list;
	}
	
	@Override
		public void deleteById(String id) {
			String sql = "DELETE FROM sanpham WHERE masp=?";
			try {
				Object[] values = { id };
				JdbcHelper.executeUpdate(sql, values);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
}
