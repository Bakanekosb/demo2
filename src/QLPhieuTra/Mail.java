/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLPhieuTra;

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
 * @author Admin
 */
public class Mail {
    public static void guiMail(String username,String password,String emailTo,String subject,String sendMessage ){
     

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailTo)
            );
            message.setSubject(subject);
            message.setText(sendMessage);

            Transport.send(message);

            System.out.println("đã gửi");

        } catch (MessagingException e) {
            System.out.println("lỗi : "+e.toString());
        }
    }
    public static void main(String[] args) {
       
        try {
            guiMail("hunghvph12990@fpt.edu.vn", "Hunghoang1233", "hunghoang99666@gmail.com", "thông báo từ thư viện sách", "thông báo bạn đã bị phạt tiền do trả sách muộn 3 ngày \n số tiền phạt : 30000 đ");
        } catch (Exception e) {
             System.out.println("hung");
        }
    }
}
