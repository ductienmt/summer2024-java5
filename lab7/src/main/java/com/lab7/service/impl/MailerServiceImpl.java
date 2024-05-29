package com.lab7.service.impl;

import com.lab7.enity.MailInfo;
import com.lab7.service.MailerService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailerServiceImpl implements MailerService {
    @Autowired
    JavaMailSender mailSender;

    List<MailInfo> list = new ArrayList<>();


    @Override
    public void send(MailInfo mail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("dinhtangductien26@gmail.com");
        helper.setReplyTo("dinhtangductien26@gmail.com");
        helper.setTo(mail.getTo());
        helper.setSubject(mail.getSubject());
        helper.setText(mail.getBody(), true);
        if (mail.getCc() != null && mail.getCc().length > 0) {
            helper.setCc(mail.getCc());
        }
        if (mail.getBcc() != null && mail.getBcc().length > 0) {
            helper.setBcc(mail.getBcc());
        }

        if (mail.getAttachments() != null) {
            for (String attachment : mail.getAttachments()) {
                // Assuming attachment is a path to the file
                helper.addAttachment(attachment, new File(attachment));
            }
        }
        // Gửi message đến SMTP server
        mailSender.send(message);

    }

    @Override
    public void send(String to, String subject, String body) throws MessagingException {
        this.send(new MailInfo(to, subject, body));
    }

    @Override
    public void queue(MailInfo mail) {
        list.add(mail);
    }

    @Override
    public void queue(String to, String subject, String body) {
        queue(new MailInfo(to, subject, body));
    }

    @Scheduled(fixedDelay = 1000)
    public void run() {
        while (!list.isEmpty()) {
            MailInfo mail = list.remove(0);
            try {
                this.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
