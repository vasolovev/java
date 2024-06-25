package ru.shop.service;

import ru.shop.domain.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCreateCategory() {
        Category category = new Category("Electronics");
        Category savedCategory = categoryService.createCategory(category);

        assertNotNull(savedCategory);
        assertEquals("Electronics", savedCategory.getName());
    }

    @Test
    public void testGetAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        assertNotNull(categories);
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("Electronics");
        categoryService.createCategory(category);

        Category updatedCategory = new Category("Updated Electronics");
        categoryService.updateCategory(category.getId(), updatedCategory);

        Category retrievedCategory = categoryService.getCategoryById(category.getId());
        assertEquals("Updated Electronics", retrievedCategory.getName());
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category("Electronics");
        categoryService.createCategory(category);

        categoryService.deleteCategory(category.getId());

        assertThrows(RuntimeException.class, () -> {
            categoryService.getCategoryById(category.getId());
        });
    }
}
