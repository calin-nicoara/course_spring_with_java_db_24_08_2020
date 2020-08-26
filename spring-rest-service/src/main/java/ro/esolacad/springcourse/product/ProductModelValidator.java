package ro.esolacad.springcourse.product;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductModelValidator implements Validator {

    @Override
    public boolean supports(final Class<?> aClass) {
        return ProductModel.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        ProductModel productModel = (ProductModel) o;

        if(productModel.getStatus().equals(ProductStatus.AVAILABLE) &&
                productModel.getPrice() == null) {
            errors.reject("productModel.priceNullForAvailable");
        }
    }
}
