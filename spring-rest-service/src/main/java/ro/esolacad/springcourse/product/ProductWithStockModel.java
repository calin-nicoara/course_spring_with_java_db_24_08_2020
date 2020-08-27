package ro.esolacad.springcourse.product;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductWithStockModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductStatus status;
    private Integer stock;
}
