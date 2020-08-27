package ro.esolacad.springcourse.productstock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStockModel {

    private Long productId;
    private Integer stock;
}
