package ru.shop.service;

import ru.shop.domain.Category;
import ru.shop.domain.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryStorageService implements StorageService {
    private Map<String, Product> products = new HashMap<>();
    private Map<String, Category> categories = new HashMap<>();

    // Implement methods for in-memory storage
}
