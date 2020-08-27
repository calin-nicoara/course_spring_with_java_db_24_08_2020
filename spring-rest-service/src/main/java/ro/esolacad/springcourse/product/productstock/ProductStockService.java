package ro.esolacad.springcourse.product.productstock;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductStockService {

    private final ProductStockFeignClient productStockFeignClient;

    public ProductStockModel findStockByProductId(final Long id) {
        String urlForStock = "http://localhost:8099/stock/" + id;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ProductStockModel> stockModelResponseEntity = restTemplate.getForEntity(urlForStock, ProductStockModel.class);

        return stockModelResponseEntity.getBody();
    }

    public ProductStockModel findStockByProductIdWithFeign(final Long id) {
        return productStockFeignClient.findStockByProductId(id).getBody();
    }
}
