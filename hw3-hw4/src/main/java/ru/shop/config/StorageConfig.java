package ru.shop.config;

import ru.shop.service.FileStorageService;
import ru.shop.service.InMemoryStorageService;
import ru.shop.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${app.storageType}")
    private String storageType;

    @Bean
    public StorageService storageService() {
        if ("memory".equalsIgnoreCase(storageType)) {
            return new InMemoryStorageService();
        } else if ("file".equalsIgnoreCase(storageType)) {
            return new FileStorageService();
        } else {
            throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }
}
