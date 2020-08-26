package ro.esolacad.springcourse.product;

public final class ProductMapper {

    private ProductMapper() {}

    public static ProductModel toProductModel(final Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }

    public static Product toProduct(final ProductModel productModel) {
        return Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .status(productModel.getStatus())
                .build();
    }
}
