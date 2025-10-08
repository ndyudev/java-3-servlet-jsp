package ndyudev.lab5.mail;

import java.io.InputStream;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.http.Part;

public class MailerFile {

    public static int sendWithFile(String from, String to, String subject, String body, Part filePart) {
        try {
            // 🔧 Cấu hình Gmail SMTP
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            final String username = "chauunhatduyyit@gmail.com";
            final String password = "cahouckivjazaavk";

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });


            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject, "UTF-8");

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(body, "text/html; charset=UTF-8");


            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            if (filePart != null && filePart.getSize() > 0) {
                MimeBodyPart attachment = new MimeBodyPart();
                InputStream fileContent = filePart.getInputStream();
                attachment.setFileName(filePart.getSubmittedFileName());
                attachment.setContent(fileContent.readAllBytes(), "application/octet-stream");
                multipart.addBodyPart(attachment);
            }

 
            message.setContent(multipart);


            Transport.send(message);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
