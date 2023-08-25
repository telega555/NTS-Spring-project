package com.example.ntsspringproject.controller;

import com.example.ntsspringproject.entity.LogInformation;
import com.example.ntsspringproject.service.LogInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LogController {
    private final LogInformationService logInformationService;
    @PostMapping("/addLog")
    private String createLogs(@RequestBody LogInformation logInfo) {
        System.out.println("Received content: " + logInfo.getContent());
        logInformationService.createCommand(logInfo.getContent());
        return "Content saved!";
    }
    @GetMapping("/getLog")
    private List<LogInformation> getLogs(){
        return logInformationService.getLogs();
    }

}
