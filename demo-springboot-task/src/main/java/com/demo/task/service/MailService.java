package com.demo.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author qichengjian
 */
@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送简单邮件
     */
    public void send01() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //邮件设置
        mailMessage.setSubject("通知-今天开会");
        mailMessage.setText("今晚7点开会");
        mailMessage.setFrom("sss@163.com");
        mailMessage.setTo("111@qq.com");

        mailSender.send(mailMessage);
    }

    /**
     * 发送复杂邮件
     */
    public void send02() throws MessagingException {
        //创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今天开会");
        helper.setText("<b style='color:red'>今晚7点开会</b>", true);
        helper.setFrom("sss@163.com");
        helper.setTo("sss@qq.com");

        //上传文件
        helper.addAttachment("1.jpg", new File("/User/1.jpg"));
        helper.addAttachment("2.jpg", new File("/User/2.jpg"));

        mailSender.send(mimeMessage);

    }

}
