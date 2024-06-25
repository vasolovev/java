package ru.shop.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.shop.domain.Category;

import java.math.BigDecimal;

public class ProductDTO {
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
    @NotNull
    private Category category;


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
