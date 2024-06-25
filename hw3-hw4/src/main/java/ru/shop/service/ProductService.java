package ru.shop.service;

import ru.shop.controller.dto.ProductDTO;
import ru.shop.domain.Product;
import ru.shop.domain.Category;
import ru.shop.repository.ProductRepository;
import ru.shop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        Optional<Category> categoryOpt = categoryRepository.findById(product.getCategory().getId());
        if (categoryOpt.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        product.setCategory(categoryOpt.get());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductBySku(String sku) {
        return productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));
    }

    public Product updateProduct(String sku, Product productDetails) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        return productRepository.save(product);
    }

    public void deleteProduct(String sku) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));
        productRepository.delete(product);
    }
}
