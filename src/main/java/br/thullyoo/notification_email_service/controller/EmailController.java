package br.thullyoo.notification_email_service.controller;

import br.thullyoo.notification_email_service.entity.email.Email;
import br.thullyoo.notification_email_service.entity.email.EmailRequest;
import br.thullyoo.notification_email_service.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Email> registerEmail(@RequestBody EmailRequest emailRequest){
            var email = emailService.registerEmail(emailRequest);
            return ResponseEntity.ok().body(email);
    }

}
