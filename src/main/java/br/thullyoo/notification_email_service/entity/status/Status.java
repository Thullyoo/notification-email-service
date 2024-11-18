package br.thullyoo.notification_email_service.entity.status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_STATUS")
public class Status {

    @Id
    @Column(name = "status_id")
    private Long id;

    private String description;

    public Status() {
    }

    public Status(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values{
        PENDING(1L, "PENDING"),
        SUCCESS(2L, "SUCCESS"),
        CANCELED(3L, "CANCELED"),
        ERROR(4L, "ERROR");

        private Long id;
        private String description;

        Values(Long id, String description){
            this.id = id;
            this.description = description;
        }

        public Status toStatus(){
            return new Status(id, description);
        }
    }
}
