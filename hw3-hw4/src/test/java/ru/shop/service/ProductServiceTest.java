package ru.shop.service;

import ru.shop.domain.Product;
import ru.shop.domain.Category;
import ru.shop.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateProduct() {
        Category category = new Category("Electronics");
        categoryRepository.save(category);

        Product product = new Product("SKU123", "Laptop", new BigDecimal("999.99"), 10, category);
        Product savedProduct = productService.createProduct(product);

        assertNotNull(savedProduct);
        assertEquals("Laptop", savedProduct.getName());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
    }

    @Test
    public void testUpdateProduct() {
        Category category = new Category("Electronics");
        categoryRepository.save(category);

        Product product = new Product("SKU123", "Laptop", new BigDecimal("999.99"), 10, category);
        productService.createProduct(product);

        Product updatedProduct = new Product("SKU123", "Updated Laptop", new BigDecimal("1099.99"), 5, category);
        productService.updateProduct("SKU123", updatedProduct);

        Product retrievedProduct = productService.getProductBySku("SKU123");
        assertEquals("Updated Laptop", retrievedProduct.getName());
        assertEquals(new BigDecimal("1099.99"), retrievedProduct.getPrice());
    }

    @Test
    public void testDeleteProduct() {
        Category category = new Category("Electronics");
        categoryRepository.save(category);

        Product product = new Product("SKU123", "Laptop", new BigDecimal("999.99"), 10, category);
        productService.createProduct(product);

        productService.deleteProduct("SKU123");

        assertThrows(RuntimeException.class, () -> {
            productService.getProductBySku("SKU123");
        });
    }
}
