package ro.esolacad.springcourse.product;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @CreatedBy
    @Column(updatable = false)
    private String userCreated;

    @LastModifiedBy
    private String userLastUpdated;

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

//    public String getDummyValue() {
//        return "dummy";
//    }


}
