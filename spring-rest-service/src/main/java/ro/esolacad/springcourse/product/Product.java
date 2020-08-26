package ro.esolacad.springcourse.product;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    public static class ProductBuilder {
        private Long id;
        private String name;
        private BigDecimal price;
        private ProductStatus status;
        private String userCreated;
        private String userLastUpdated;

        ProductBuilder() {
        }

        public ProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder status(ProductStatus status) {
            this.status = status;
            return this;
        }

        public ProductBuilder userCreated(String userCreated) {
            this.userCreated = userCreated;
            return this;
        }

        public ProductBuilder userLastUpdated(String userLastUpdated) {
            this.userLastUpdated = userLastUpdated;
            return this;
        }

        public Product build() {
            return new Product(id, name, price, status, userCreated, userLastUpdated);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", status=" + this.status + ", userCreated=" + this.userCreated + ", userLastUpdated=" + this.userLastUpdated + ")";
        }
    }

//    public String getDummyValue() {
//        return "dummy";
//    }


}
