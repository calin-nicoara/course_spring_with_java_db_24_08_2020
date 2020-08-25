package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import ro.esolacad.springcourse.jpa.manyToOne.Category;
import ro.esolacad.springcourse.jpa.manyToOne.CategoryRepository;
import ro.esolacad.springcourse.jpa.manyToOne.ProductWithCategory;
import ro.esolacad.springcourse.jpa.manyToOne.ProductWithCategoryRepository;

@SpringBootTest
public class JpaRelationsTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductWithCategoryRepository productWithCategoryRepository;

    @Test
    public void saveProductAndCategory() {
        Category category = new Category(null, "Bauturi", true);

        Category savedCategory = categoryRepository.save(category);

        Category newCategory = new Category();
        newCategory.setId(savedCategory.getId());
        ProductWithCategory product = new ProductWithCategory(null,
                "Nestea", BigDecimal.valueOf(3.5),
                newCategory);

        ProductWithCategory savedProduct = productWithCategoryRepository.save(product);


        Optional<ProductWithCategory> productWithCategory = productWithCategoryRepository.findById(savedProduct.getId());

        System.out.println(productWithCategory.get().getCategory());
    }
}
