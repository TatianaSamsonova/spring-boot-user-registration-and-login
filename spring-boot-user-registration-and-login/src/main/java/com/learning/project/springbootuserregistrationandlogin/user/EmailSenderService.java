package com.learning.project.springbootuserregistrationandlogin.user;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 10:56 AM
 * @project spring-boot-user-registration-and-login
 */

@Service
@AllArgsConstructor
public class EmailSenderService {

    private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(SimpleMailMessage email){
        javaMailSender.send(email);
    }
}
