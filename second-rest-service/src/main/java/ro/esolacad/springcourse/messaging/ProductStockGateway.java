package ro.esolacad.springcourse.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import ro.esolacad.springcourse.productstock.ProductStockModel;

@MessagingGateway
public interface ProductStockGateway {

    @Gateway(requestChannel = "productStockChannel")
    void sendProduct(ProductStockModel productModel);
}
