package ro.esolacad.springcourse.product.productstock;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductStockFeignClientFallback implements ProductStockFeignClient{

    @Override
    public ResponseEntity<ProductStockModel> findStockByProductId(final Long productId) {
        System.out.println("USED FALLBACK!");

        return ResponseEntity.ok(ProductStockModel.builder()
                .productId(productId)
                .stock(0)
                .build());
    }
}
