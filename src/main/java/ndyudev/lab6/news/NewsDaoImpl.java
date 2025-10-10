package ndyudev.lab6.news;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ndyudev.lab6.slider.JdbcHelper;

public class NewsDaoImpl implements NewsDao {

	private static final String SQL_SELECT_HOME = "SELECT * FROM NEWS WHERE Home = 1";

	private static final String SQL_SELECT_BY_ID = "SELECT * FROM NEWS WHERE Id = ?";

	private static final String SQL_INSERT = "INSERT INTO NEWS (Id, Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SQL_UPDATE = "UPDATE NEWS SET Title=?, Content=?, Image=?, PostedDate=?, Author=?, "
			+ "ViewCount=?, CategoryId=?, Home=? WHERE Id=?";

	private static final String SQL_DELETE = "DELETE FROM NEWS WHERE Id = ?";

	private static final String SQL_INCREASE_VIEW = "UPDATE NEWS SET ViewCount = ViewCount + 1 WHERE Id = ?";

	private static final String SQL_TOP3_VIEW = "SELECT TOP 3 * FROM NEWS ORDER BY ViewCount DESC";

	private static final String SQL_TOP3_LATEST = "SELECT TOP 3 * FROM NEWS ORDER BY PostedDate DESC";

	private static final String SQL_FIND_BY_AUTHOR = "SELECT * FROM NEWS WHERE Author = ?";

	private News map(ResultSet rs) throws SQLException {
		News n = new News();
		n.setId(rs.getString("Id"));
		n.setTitle(rs.getString("Title"));
		n.setContent(rs.getString("Content"));
		n.setImage(rs.getString("Image"));
		n.setPostedDate(rs.getDate("PostedDate"));
		n.setAuthor(rs.getString("Author"));
		n.setViewCount(rs.getInt("ViewCount"));
		n.setCategoryId(rs.getString("CategoryId"));
		n.setHome(rs.getBoolean("Home"));
		return n;
	}

	@Override
	public List<News> findAllHomeNews() {
		List<News> list = new ArrayList<>();
		try (ResultSet rs = JdbcHelper.executeQuery(SQL_SELECT_HOME)) {
			while (rs.next())
				list.add(map(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public News findById(String id) {
		try (ResultSet rs = JdbcHelper.executeQuery(SQL_SELECT_BY_ID, id)) {
			if (rs.next())
				return map(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(News news) {
		try {
			JdbcHelper.executeUpdate(SQL_INSERT, news.getId(), news.getTitle(), news.getContent(), news.getImage(),
					news.getPostedDate(), news.getAuthor(), news.getViewCount(), news.getCategoryId(), news.isHome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(News news) {
		try {
			JdbcHelper.executeUpdate(SQL_UPDATE, news.getTitle(), news.getContent(), news.getImage(),
					news.getPostedDate(), news.getAuthor(), news.getViewCount(), news.getCategoryId(), news.isHome(),
					news.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		try {
			JdbcHelper.executeUpdate(SQL_DELETE, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void increaseViewCount(String id) {
		try {
			JdbcHelper.executeUpdate(SQL_INCREASE_VIEW, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<News> findTop3ByViewCount() {
		List<News> list = new ArrayList<>();
		try (ResultSet rs = JdbcHelper.executeQuery(SQL_TOP3_VIEW)) {
			while (rs.next())
				list.add(map(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<News> findTop3Latest() {
		List<News> list = new ArrayList<>();
		try (ResultSet rs = JdbcHelper.executeQuery(SQL_TOP3_LATEST)) {
			while (rs.next())
				list.add(map(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<News> findByAuthor(String authorId) {
		List<News> list = new ArrayList<>();
		try (ResultSet rs = JdbcHelper.executeQuery(SQL_FIND_BY_AUTHOR, authorId)) {
			while (rs.next())
				list.add(map(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
