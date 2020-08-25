package ro.esolacad.springcourse.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query("select p from Product p where p.price >= :price")
//    @Query(value = "", nativeQuery = true)
    List<Product> findAllByPriceGreaterThanEqual(@Param("price") BigDecimal price);

    List<Product> findByNameLike(String likeName);

    Optional<Product> findByPriceLessThan(@Param("price") BigDecimal price);

//    List<Product> findByNameLikeAndPriceGreaterThanEqual
}
