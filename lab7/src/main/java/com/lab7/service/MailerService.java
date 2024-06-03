package com.lab7.service;

import com.lab7.enity.MailInfo;
import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface MailerService {
    void send(MailInfo mail) throws MessagingException;
    void send(String to, String subject, String body) throws MessagingException;
    void queue(MailInfo mail);
    void queue(String to, String subject, String body);
}

