package ru.shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String storageType;

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }
}
