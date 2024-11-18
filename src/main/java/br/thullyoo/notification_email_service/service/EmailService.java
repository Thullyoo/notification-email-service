package br.thullyoo.notification_email_service.service;

import br.thullyoo.notification_email_service.entity.email.Email;
import br.thullyoo.notification_email_service.entity.email.EmailRequest;
import br.thullyoo.notification_email_service.entity.status.Status;
import br.thullyoo.notification_email_service.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    private final JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public Email registerEmail(EmailRequest emailRequest){

        Email email = new Email();
        email.setFrom(emailFrom);
        email.setTo(emailRequest.emailTo());
        email.setDateTime(emailRequest.dateTime());
        email.setMessage(emailRequest.message());
        email.setStatus(Status.Values.PENDING.toStatus());
        email.setSubject(emailRequest.subject());

        emailRepository.save(email);

        return email;
    }

}
