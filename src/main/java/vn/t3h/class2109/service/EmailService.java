package vn.t3h.class2109.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String email;


    public void sendMail(String title, String body, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setText(body);
        message.setSubject(title);
        message.setTo(to);
        javaMailSender.send(message);
    }
}
