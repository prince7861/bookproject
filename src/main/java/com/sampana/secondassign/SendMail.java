package com.sampana.secondassign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SendMail {
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String fromEmail, String toEmail, String subject,String body)
    {
        File f=new File("D:\\bookproject\\bookdata.xlsx");
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailSender.send(mailMessage);
        System.out.println("Email sent successfully");
    }
}
