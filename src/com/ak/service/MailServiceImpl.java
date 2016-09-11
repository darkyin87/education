package com.ak.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
 
    @Autowired
    JavaMailSender mailSender;
 
    @Override
    public void sendEmail() {
 
        //ProductOrder order = (ProductOrder) object;
 
        MimeMessagePreparator preparator = getMessagePreparator();
 
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    private MimeMessagePreparator getMessagePreparator() {
 
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
 
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress("gokul.dharumar@gmail.com"));
                mimeMessage.setText("Dear Gokul"
                        + ", Thanks for becoming a volunteer. Someone from the team will contact to you at the earliest");
                mimeMessage.setSubject("Your order on Demoapp");
            }
        };
        return preparator;
    }
 
}