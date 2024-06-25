package ru.shop.controller.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.shop.controller.dto.ProductDTO;
import ru.shop.domain.Product;
import ru.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO productDTO) {

        Product product = new Product(productDTO.getSku(), productDTO.getName(), productDTO.getPrice(), productDTO.getStock(), productDTO.getCategory());

        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        return productService.getProductBySku(sku);
    }

    @PutMapping("/{sku}")
    public Product updateProduct(@PathVariable String sku, @RequestBody Product productDetails) {
        return productService.updateProduct(sku, productDetails);
    }

    @DeleteMapping("/{sku}")
    public void deleteProduct(@PathVariable String sku) {
        productService.deleteProduct(sku);
    }
}
