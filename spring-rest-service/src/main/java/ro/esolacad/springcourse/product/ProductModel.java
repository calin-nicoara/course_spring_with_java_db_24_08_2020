package ro.esolacad.springcourse.product;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {

    private Long id;

//    @NotNull
//    @NotEmpty
    @NotBlank
    private String name;

//    @DecimalMin("0.99")
    private BigDecimal price;
    private ProductStatus status;
}
