package br.thullyoo.notification_email_service.Scheduler;

import br.thullyoo.notification_email_service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class EmailScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailScheduler.class);

    private final EmailService emailService;

    public EmailScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkEmailSend(){
        LOGGER.info("Rodando no horario " + LocalDateTime.now());
        this.emailService.checkEmailAndSend();
    }

}
