package com.example.demo.email;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail() throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("valkyrie0021@gmail.com");
        helper.setTo("iskandarchrist@gmail.com");
        helper.setSubject("Test email");
        helper.setText("This is a test email");
        javaMailSender.send(message);
    }
}
