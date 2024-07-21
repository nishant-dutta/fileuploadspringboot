package com.example.fileuploadspringboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        if(filename == null || filename.isBlank())
            return "Invalid File name!";
        System.out.println(file.getSize());

        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(file.getBytes());
        }

        return file.getOriginalFilename();
    }
}
