package ru.shop.controller.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
