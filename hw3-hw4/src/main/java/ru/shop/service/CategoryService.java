package ru.shop.service;

import ru.shop.domain.Category;
import ru.shop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    public Category updateCategory(UUID id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        category.setName(categoryDetails.getName());
        category.setUrl(categoryDetails.getUrl());
        return categoryRepository.save(category);
    }

    public void deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        categoryRepository.delete(category);
    }
}
