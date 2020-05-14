package br.josias.emailsender.resource;

import br.josias.emailsender.domain.Email;
import br.josias.emailsender.service.EmailService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint for e-mail trigger
 * @author josias
 */
@RestController
@RequestMapping(value = "/email")
public class EmailResouce {
    
    @Autowired
    EmailService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Email> sendMail(@Valid @RequestBody Email email){
        service.sendHtmlEmail(email);
        return ResponseEntity.noContent().build();
    }
}
