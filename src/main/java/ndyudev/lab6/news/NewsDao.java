package ndyudev.lab6.news;

import java.util.List;

public interface NewsDao {
    List<News> findAllHomeNews();
    News findById(String id);
    void insert(News news);
    void update(News news);
    void delete(String id);
    void increaseViewCount(String id);
    List<News> findTop3ByViewCount();
    List<News> findTop3Latest();
    List<News> findByAuthor(String authorId);
}
