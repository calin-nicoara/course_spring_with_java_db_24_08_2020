package ro.esolacad.springcourse.product.productstock;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="stock-service", url="http://localhost:8099",
    fallback = ProductStockFeignClientFallback.class)
public interface ProductStockFeignClient {

    @RequestMapping(value = "/stock/{productId}", method= RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductStockModel> findStockByProductId(@PathVariable Long productId);
}
