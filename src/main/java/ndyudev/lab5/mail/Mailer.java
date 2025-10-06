package ndyudev.lab5.mail;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Mailer {

	public static int send(String from, String to, String subject, String body) {
		// Thông số kết nối GMail
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		//props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
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
			
			// Gửi mail
			Transport.send(mail);
		} catch (Exception e) { return -1; }
		return 1;
	} 
	
	public static void main(String[] args) {
		Mailer.send("chauunhatduyyit@gmail.com", "ndyu.itech@gmail.com", "Java 3 Servlet | Send Mail", "Send Mail!");
	}
}
