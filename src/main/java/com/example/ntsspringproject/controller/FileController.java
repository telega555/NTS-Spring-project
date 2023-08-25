package com.example.ntsspringproject.controller;

import org.springframework.ui.Model;
import com.example.ntsspringproject.entity.FileInfo;
import com.example.ntsspringproject.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        try {

            return ResponseEntity.ok(fileService.saveFile(file));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file.");

        }
    }

    @PostMapping("/info")
    public FileInfo getInfo(@RequestParam("fileName") String fileName){
        FileInfo fileInfo = fileService.fileInformation(fileName);
        return fileInfo;
    }


}
