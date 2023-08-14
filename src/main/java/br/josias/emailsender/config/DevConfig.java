package br.josias.emailsender.config;

import br.josias.emailsender.service.DevMockEmailService;
import br.josias.emailsender.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 *
 * @author josias
 */
@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    EmailService emailService() {
        return new DevMockEmailService();
    }
}
