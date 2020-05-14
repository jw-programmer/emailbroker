package br.josias.emailsender.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/**
 * E-mail class to REST
 * @author josias
 */
public class Email implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message="Não pode ser Vazio")
    @javax.validation.constraints.Email(message = "E-mail do remetente inválido")
    private String recipient;
    
    @NotEmpty(message="Não pode ser Vazio")
    private String sender;
    
    @NotEmpty(message="Não pode ser Vazio")
    private String subject;
    
    @NotEmpty(message="Não pode ser Vazio")
    private String message;

    public Email() {
    }

    public Email(String recipient, String sender, String subject, String message, Date instantOfSending) {
        this.recipient = recipient;
        this.sender = sender;
        this.subject = subject;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.recipient);
        hash = 37 * hash + Objects.hashCode(this.sender);
        hash = 37 * hash + Objects.hashCode(this.subject);
        hash = 37 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        if (!Objects.equals(this.recipient, other.recipient)) {
            return false;
        }
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }
    
    
}
