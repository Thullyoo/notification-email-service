package br.thullyoo.notification_email_service.repository;

import br.thullyoo.notification_email_service.entity.email.Email;
import br.thullyoo.notification_email_service.entity.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
    List<Email> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
