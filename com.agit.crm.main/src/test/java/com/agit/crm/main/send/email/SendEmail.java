package com.agit.crm.main.send.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 10991001
 */
public class SendEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String username = "bayuhendra1078@gmail.com";
        final String password = "bayuhendra1993";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bayuhendra1078@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bayuhendra1078@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("atmaji.tri@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("zakymukhoyyar@gmail.com "));
            message.setSubject("Testing Subject");
            message.setText("Dear ALL,"
                    + "\n\n Cek Email, please!");

            Transport.send(message);

            System.out.println("Sending Email Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
