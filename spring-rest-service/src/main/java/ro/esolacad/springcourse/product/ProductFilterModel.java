package ro.esolacad.springcourse.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductFilterModel {

    private Integer pageNumber = 10;
    private Integer pageSize = 0;
    private String nameEquals;
    private BigDecimal priceGreaterThan;
}
