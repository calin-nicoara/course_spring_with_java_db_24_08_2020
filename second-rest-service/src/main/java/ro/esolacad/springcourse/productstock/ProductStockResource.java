package ro.esolacad.springcourse.productstock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ro.esolacad.springcourse.messaging.ProductStockGateway;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class ProductStockResource {

    private final ProductStockGateway productStockGateway;

    @GetMapping("/{productId}")
    public ProductStockModel findStockByProductId(
            @PathVariable Long productId) {
        return ProductStockModel
                .builder()
                .productId(productId)
                .stock(10)
                .build();
    };

    @PostMapping("/sendStock")
    public void sendStock() {
        productStockGateway.sendProduct(
                ProductStockModel
                        .builder()
                        .productId(2L)
                        .stock(10)
                        .build()
        );
    }
}
