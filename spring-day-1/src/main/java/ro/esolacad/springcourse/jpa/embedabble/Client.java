package ro.esolacad.springcourse.jpa.embedabble;

import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Client extends AbstractAuditable{

    @Id
    @GeneratedValue(generator = "CLIENT_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CLIENT_SEQ_GEN", sequenceName = "CLIENT_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    private BigDecimal credit;

    private Integer numberOfOrders;

    private String newField;

    @Embedded
    private ClientAddress clientAddress;

//    private String streetName;
//
//    private String streetNumber;

//    @Type(type = "org.hibernate.type.LocalDateTimeType")
//    private LocalDateTime createdAt;
//
//    @Type(type = "org.hibernate.type.LocalDateTimeType")
//    private LocalDateTime updatedAt;
//
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
