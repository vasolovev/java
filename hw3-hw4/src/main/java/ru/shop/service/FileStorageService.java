package ru.shop.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService implements StorageService {
    private Path storagePath = Paths.get("storage");

    // Implement methods for file storage
}
