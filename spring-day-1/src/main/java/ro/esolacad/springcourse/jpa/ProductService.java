package ro.esolacad.springcourse.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return  productRepository.save(product);
    }

    public List<Product> findAll(int pageNumber, int pageSize) {
//        Sort.by(Sort.Order.asc("id"), Sort.Order.desc("price"));
//        Sort.by("id", "price")
//        Sort.by(Sort.Direction.DESC, "id", "price");

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC, "id"));

        Page<Product> page = productRepository.findAll(pageRequest);

        return page.getContent();
    }
}
