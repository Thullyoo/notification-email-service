package br.thullyoo.notification_email_service.entity.email;

import br.thullyoo.notification_email_service.entity.status.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAILS")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "email_id")
    private UUID id;

    private String emailTo;

    private String emailFrom;

    private String subject;

    private String message;

    @ManyToOne()
    @JoinColumn(name = "status_id")
    private Status status;

    private LocalDateTime dateTime;

    public Email() {
    }

    public Email(UUID id, String to, String from, String subject, String message, Status status, LocalDateTime dateTime) {
        this.id = id;
        this.emailTo = to;
        this.emailFrom = from;
        this.subject = subject;
        this.message = message;
        this.status = status;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTo() {
        return emailTo;
    }

    public void setTo(String to) {
        this.emailTo = to;
    }

    public String getFrom() {
        return emailFrom;
    }

    public void setFrom(String from) {
        this.emailFrom = from;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
