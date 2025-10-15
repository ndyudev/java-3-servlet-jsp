package ndyudev.lab5.mail;

import java.io.File;
import java.io.InputStream;
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
import jakarta.servlet.http.Part;

public class MailerFile {

    public static int sendWithFile(String from, String to, String subject, String body, Part filePart) {
        try {
            // ⚙️ Cấu hình SMTP Gmail
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");

            // 🔐 Đăng nhập Gmail
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String username = "chauunhatduyyit@gmail.com";
                    String password = ""; // App password Gmail
                    return new PasswordAuthentication(username, password);
                }
            });

            // 📧 Tạo mail
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(RecipientType.TO, to);
            message.setSubject(subject, "utf-8");
            message.setReplyTo(message.getFrom());

            // ✉️ Nội dung text
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(body, "text/html; charset=utf-8");

            // 📎 Multipart (gộp text + file)
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            // 📂 File đính kèm từ form upload
            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachment = new MimeBodyPart();
                try (InputStream fileContent = filePart.getInputStream()) {
                    attachment.setFileName(filePart.getSubmittedFileName());
                    attachment.setContent(fileContent.readAllBytes(), "application/octet-stream");
                }
                multipart.addBodyPart(attachment);
            }

            message.setContent(multipart);

            // 🚀 Gửi mail
            Transport.send(message);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
