package br.josias.emailsender.config;

import br.josias.emailsender.service.EmailService;
import br.josias.emailsender.service.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
/**
 *
 * @author josias
 */
public class DevConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }
}
