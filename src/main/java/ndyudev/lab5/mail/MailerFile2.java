package ndyudev.lab5.mail;

import java.io.File;
import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class MailerFile2 {

	public static int send(String from, String to, String subject, String body, String filePath) {
		// Thông số kết nối GMail
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		// props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		// Đăng nhập GMail
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "chauunhatduyyit@gmail.com";
				String password = "";
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			// Tạo mail
			MimeMessage mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress(from));
			mail.setRecipients(RecipientType.TO, to);
			mail.setSubject(subject, "utf-8");
			mail.setText(body, "utf-8", "html");
			mail.setReplyTo(mail.getFrom());

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(body, "text/html; charset=utf-8");

			// File đính kèm
			MimeBodyPart filePart = new MimeBodyPart();
			File file = new File(filePath);
			filePart.setDataHandler(new DataHandler(new FileDataSource(file)));
			filePart.setFileName(file.getName());

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(filePart);
			mail.setContent(multipart);

			// Gửi mail
			Transport.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	public static void main(String[] args) {
		MailerFile2.send("chauunhatduyyit@gmail.com", "thaianhvy@gmail.com", "Send File Java Servlet on JSP",
				"Send mail kèm file !", "C:\\Users\\Chau Nhat Duy\\Documents\\Account\\TikTokShop.xlsx");
	}
}