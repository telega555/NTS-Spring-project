package com.example.ntsspringproject.service;

import com.example.ntsspringproject.exception.ResourceNotFoundException;
import com.example.ntsspringproject.repository.FileRepository;
import com.example.ntsspringproject.entity.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/images";


    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    public String saveFile(MultipartFile file) throws IOException {
        //        String one = String.valueOf(LocalDateTime.now()).replace("-","");
//        String two = one.replace("T","_");
//        String three = two.replace(":", "");
//        String four = three.split("\\.")[0];
//        System.out.println(four);
        String fileName = String.valueOf(LocalDateTime.now())
                .replace("-", "")
                .replace("T", "_")
                .replace(":", "")
                .split("\\.")[0];
        String imageType = List.of(file.getContentType().split("/")).get(1);
        String fileFullName = fileName + "." + imageType;
        Path path = Paths.get(uploadDir, fileFullName);
        Files.write(path, file.getBytes());
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileFullName);
        fileInfo.setFilePath(String.valueOf(path));
        fileInfo.setFileData(LocalDateTime.now());

        fileRepository.save(fileInfo);
        return "File uploaded successfully.";

    }
    public FileInfo fileInformation(String fileName){
        FileInfo fileInfo = fileRepository.findByFileName(fileName).orElseThrow(() -> new ResourceNotFoundException("FileInfo", "fileName", fileName ));
        return fileInfo;

    }

}
