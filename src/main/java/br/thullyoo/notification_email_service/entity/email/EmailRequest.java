package br.thullyoo.notification_email_service.entity.email;

import java.time.LocalDateTime;

public record EmailRequest(String emailTo, String subject, String message, LocalDateTime dateTime) {
}
