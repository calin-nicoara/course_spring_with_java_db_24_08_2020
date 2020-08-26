package ro.esolacad.springcourse.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import ro.esolacad.springcourse.GenericListModel;
import ro.esolacad.springcourse.NotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public GenericListModel<ProductModel> findAllProductsOld(final Integer pageSize, final Integer pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("id"));

        Page<Product> productPage = productRepository.findAll(pageRequest);

        return getProductModelsFromPage(productPage);
    }

    @Transactional(readOnly = true)
    public GenericListModel<ProductModel> findAllProducts(final ProductFilterModel productFilterModel) {
        PageRequest pageRequest = PageRequest.of(
                productFilterModel.getPageNumber(),
                productFilterModel.getPageSize(),
                Sort.by("id"));

        Specification<Product> baseSpecification = Specification.where(null);

        if(StringUtils.hasText(productFilterModel.getNameEquals())) {
            Specification<Product> nameSpecification = (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("name"),productFilterModel.getNameEquals());

            baseSpecification = baseSpecification.and(nameSpecification);
        }

        if(productFilterModel.getPriceGreaterThan() != null) {
            Specification<Product> priceSpecification = (root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThan(root.get("price"), productFilterModel.getPriceGreaterThan());

            baseSpecification = baseSpecification.and(priceSpecification);
        }


        Page<Product> productPage = productRepository.findAll(baseSpecification, pageRequest);

        return getProductModelsFromPage(productPage);
    }

    private GenericListModel<ProductModel> getProductModelsFromPage(final Page<Product> productPage) {
        List<ProductModel> productModels = productPage.getContent()
                .stream()
                .map(ProductMapper::toProductModel)
                .collect(Collectors.toList());

        return GenericListModel.<ProductModel>builder()
                .items(productModels)
                .totalElements(productPage.getTotalElements())
                .totalPages(productPage.getTotalPages())
                .build();
    }


    public Optional<ProductModel> findById(final Long productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::toProductModel);
    }

    public ProductModel findByIdOrThrow(final Long productId) {
        return productRepository.findById(productId)
                .map(ProductMapper::toProductModel)
                .orElseThrow(() -> new NotFoundException("Product with id:" + productId + " not found"));
    }

    public void saveProduct(final ProductModel productModel) {
        Product product = ProductMapper.toProduct(productModel);
        productRepository.save(product);
    }

    public void deleteProduct(final Long productId) {
        productRepository.deleteById(productId);
    }
}
