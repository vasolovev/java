package ru.shop.controller.http;

import ru.shop.controller.dto.CategoryDTO;
import ru.shop.domain.Category;
import ru.shop.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName());

        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody Category categoryDetails) {
        return categoryService.updateCategory(id, categoryDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
    }
}
