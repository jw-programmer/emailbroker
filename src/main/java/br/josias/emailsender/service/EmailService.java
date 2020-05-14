package br.josias.emailsender.service;

import br.josias.emailsender.domain.Email;
import javax.mail.internet.MimeMessage;

/**
 * This interface needs to be implemented by anyone who wants to create different types of e-mail, and expanded to do so.
 * @author josias
 */
public interface EmailService {
    void sendHtmlEmail(Email email);
    void sendMail(MimeMessage msg);
}
