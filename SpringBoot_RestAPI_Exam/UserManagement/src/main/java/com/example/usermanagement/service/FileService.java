package com.example.usermanagement.service;

import com.example.usermanagement.response.FileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileResponse uploadFile(MultipartFile file);

    byte[] readFile(String id);
}
