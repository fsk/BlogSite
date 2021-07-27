package com.fsk.blog.controllers;

import com.fsk.blog.configuration.EmailCfg;
import com.fsk.blog.entities.email.Mail;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/contact-me")
@RequiredArgsConstructor
public class UserContactMeController {

    private final EmailCfg emailCfg;

    @PostMapping
    public void sendFeedBack(@RequestBody Mail mail, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid");
        }

        //Create E Mail Sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());


        //Create E Mail Instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mail.getEmail());
        mailMessage.setTo("furkansahinkulaksiz@gmail.com");
        mailMessage.setSubject("New Mail from" + mail.getName());
        mailMessage.setText(mail.getContent());


        //Send Mail
        mailSender.send(mailMessage);


    }
}
