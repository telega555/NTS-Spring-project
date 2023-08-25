package com.example.ntsspringproject.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class FileInfoDto {
    private String fileName;
    private LocalTime fileData;
    private String filePath;
}
