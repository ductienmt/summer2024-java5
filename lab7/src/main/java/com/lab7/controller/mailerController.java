package com.lab7.controller;

import com.lab7.enity.MailInfo;
import com.lab7.service.ParamService;
import com.lab7.service.impl.MailerServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mailer")
public class mailerController {
    @Autowired
    MailerServiceImpl mailerService;

    @Autowired
    ParamService paramService;

    @Autowired
    private ServletContext servletContext;


    @GetMapping("/form")
    public String send(Model model) {
        MailInfo mail = new MailInfo();
        model.addAttribute("email", mail);
        return "mail/form";
    }

    @Value("${upload.folder}")
    private String uploadFolder;

    @PostMapping("/send")
    public String sendMail(
            @RequestParam("to") String to,
            @RequestParam("cc") String cc,
            @RequestParam("bcc") String bcc,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body,
            @RequestParam(value = "attachments", required = false) MultipartFile[] attachments
    ) throws IOException {
        MailInfo mailInfo = new MailInfo();
        mailInfo.setTo(to);
        // Filter out empty strings
        mailInfo.setCc(Arrays.stream(cc.split(","))
                .filter(email -> !email.trim().isEmpty())
                .toArray(String[]::new));
        mailInfo.setBcc(Arrays.stream(bcc.split(","))
                .filter(email -> !email.trim().isEmpty())
                .toArray(String[]::new));
        mailInfo.setSubject(subject);
        mailInfo.setBody(body);

        if (attachments != null && attachments.length > 0) {
            String[] attachmentPaths = new String[attachments.length];

            // Define the path to the resources directory
            String resourcePath = uploadFolder;
            for (int i = 0; i < attachments.length; i++) {
                MultipartFile attachment = attachments[i];
                if (attachment.isEmpty()) {
                    continue;
                }
                try {
                    File savedFile = paramService.save(attachment, resourcePath);
                    attachmentPaths[i] = savedFile.getAbsolutePath();
                } catch (RuntimeException e) {
                    throw new IOException("Could not save attachment: " + attachment.getOriginalFilename(), e);
                }
            }
            mailInfo.setAttachments(attachmentPaths);
        } else {
            mailInfo.setAttachments(new String[0]);
        }

        mailerService.queue(mailInfo);
        return "mail/result";
    }


}
