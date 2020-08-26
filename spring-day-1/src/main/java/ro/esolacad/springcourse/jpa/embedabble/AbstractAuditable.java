package ro.esolacad.springcourse.jpa.embedabble;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditable {

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @LastModifiedDate
    private LocalDateTime updatedAt;

//    @PrePersist
//    public void beforeCreate() {
//        LocalDateTime now = LocalDateTime.now();
//        createdAt = now;
//        updatedAt = now;
//    }
//
//    @PreUpdate
//    public void beforeUpdate() {
//        updatedAt = LocalDateTime.now();
//    }
}
