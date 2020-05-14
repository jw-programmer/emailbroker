/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.josias.emailsender.service;

import br.josias.emailsender.domain.Email;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author josias
 */
public abstract class AbstractEmailService implements EmailService{
    
    @Autowired
    private TemplateEngine engine;
    
    @Autowired
    private JavaMailSender javaMail;
    
    @Value("${default.sender}")
    private String sender;
    
    @Override
    public void sendHtmlEmail(Email email) {
        MimeMessage msg;
        try{
            msg = PrepareMimeMessage(email);
            sendMail(msg);
        }catch(MessagingException e){
        
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    private MimeMessage PrepareMimeMessage(Email email) throws MessagingException{
        MimeMessage mm = javaMail.createMimeMessage();
        MimeMessageHelper mh = new MimeMessageHelper(mm, true);
        mh.setTo(email.getRecipient());
        mh.setFrom(sender);
        mh.setSubject(email.getSubject());
        
        Date instantOfSending = new Date(System.currentTimeMillis());
        mh.setSentDate(instantOfSending);
        
        mh.setText(htmlToTemplate(email, instantOfSending), true);
        return mm;
        
    }

    private String htmlToTemplate(Email email, Date instante) {
        Context context = new Context();
        context.setVariable("email", email);
        context.setVariable("instante", instante);
        return engine.process("email/EmailBody.html", context);
    }
    
}
