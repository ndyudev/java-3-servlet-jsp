package ndyudev.lab6.news;

import java.sql.Date;
import java.util.List;

public class MainNewDao {
    public static void main(String[] args) {
        NewsDao dao = new NewsDaoImpl();

        try {
//            News n = new News(
//                    "NEWS1043",
//                    "Bản tin sáng",
//                    "Nội dung demo",
//                    "img1.jpg",
//                    new Date(System.currentTimeMillis()),
//                    "PV001",
//                    10,
//                    "CAT001",
//                    true
//            );
//
//            dao.insert(n);
//            System.out.println("Đã thêm bản tin mới: " + n.getTitle());
        	
        	dao.delete("NEWS1043");

            String idFind = "NEWS1043";
            News news = dao.findById(idFind);
            if (news != null) {
                System.out.println("Tìm thấy tin: " + news.getTitle());
            } else {
                System.out.println("Không tìm thấy tin tức với ID: " + idFind);
            }
//
//            dao.increaseViewCount(idFind);
//            System.out.println("Đã tăng lượt xem cho tin ID: " + idFind);
//
//            System.out.println("Top 3 theo lượt xem:");
//            List<News> top3Views = dao.findTop3ByViewCount();
//            if (top3Views.isEmpty()) {
//                System.out.println("Không có dữ liệu.");
//            } else {
//                top3Views.forEach(x ->
//                        System.out.println("- " + x.getTitle() + " (" + x.getViewCount() + " views)")
//                );
//            }
//
//            System.out.println("Top 3 bản tin mới nhất:");
//            List<News> top3Latest = dao.findTop3Latest();
//            if (top3Latest.isEmpty()) {
//                System.out.println("Không có dữ liệu.");
//            } else {
//                top3Latest.forEach(x ->
//                        System.out.println("- " + x.getTitle() + " (Ngày đăng: " + x.getPostedDate() + ")")
//                );
//            }

        } catch (Exception e) {
            System.err.println("Lỗi khi thao tác với database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
