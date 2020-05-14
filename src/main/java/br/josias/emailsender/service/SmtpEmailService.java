package br.josias.emailsender.service;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Possibility to send of smtp
 * @author josias
 */
public class SmtpEmailService extends AbstractEmailService{
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(MimeMessage msg) {
        mailSender.send(msg);//To change body of generated methods, choose Tools | Templates.
    }
    
}
