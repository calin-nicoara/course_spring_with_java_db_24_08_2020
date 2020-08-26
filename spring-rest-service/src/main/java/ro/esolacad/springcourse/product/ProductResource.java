package ro.esolacad.springcourse.product;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import ro.esolacad.springcourse.GenericListModel;

//@Controller
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;
    private final ProductModelValidator productModelValidator;

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/old_version")
    public GenericListModel<ProductModel> findAllProductsOld(
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber
    ) {
//        System.out.println("FIND ALL PRODUCTS");

        return productService.findAllProductsOld(pageSize, pageNumber);
    }

    @GetMapping()
    public GenericListModel<ProductModel> findAllProducts(
            @ModelAttribute ProductFilterModel productFilterModel,
            @RequestHeader(required = false, value ="username") String username
    ) {
//        System.out.println("FIND ALL PRODUCTS");
        System.out.println();
        System.out.println(username);
        System.out.println();
        return productService.findAllProducts(productFilterModel);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long productId) {
        return productService.findById(productId)
                .map(productModel -> ResponseEntity.ok(productModel))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/v2/{productId}")
    public ResponseEntity<ProductModel> findByIdThrowNotFound(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findByIdOrThrow(productId));
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductModel productModel,
                                         BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        productModelValidator.validate(productModel,bindingResult);

        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        productService.saveProduct(productModel);

        return ResponseEntity.ok(null);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Long productId,
                              @RequestBody ProductModel productModel) {
        productModel.setId(productId);
        productService.saveProduct(productModel);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/error")
    public void firstError() {
        throw new RuntimeException("Hello there!");
    }

}
