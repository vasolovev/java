package ru.shop.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {

    @jakarta.persistence.Id
    @Id
    private UUID id;
    @NotNull
    private String sku;
    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotNull
    @Min(0)
    private int stock;

    @ManyToOne
    private Category category;

    public Product() {}

    public Product(String sku, String name, BigDecimal price, int stock, Category category) {
        this.id = UUID.randomUUID();
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
