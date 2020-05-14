package br.josias.emailsender.config;

import br.josias.emailsender.service.EmailService;
import br.josias.emailsender.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author josias
 */
@Configuration
@Profile("prod")
public class ProdConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }

}
