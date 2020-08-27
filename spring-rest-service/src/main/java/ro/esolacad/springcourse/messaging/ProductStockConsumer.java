package ro.esolacad.springcourse.messaging;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import ro.esolacad.springcourse.product.productstock.ProductStockModel;

@Component
public class ProductStockConsumer {

    @StreamListener("productStockChannel")
    public void consumeProductStock(Message<ProductStockModel> productStockModelMessage) {
        System.out.println("------------------------------");
        System.out.println(productStockModelMessage.getPayload());
        System.out.println("------------------------------");
    }
}
