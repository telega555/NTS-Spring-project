package com.example.ntsspringproject.service;

import com.example.ntsspringproject.dto.LogInformationRequestDto;
import com.example.ntsspringproject.entity.FileInfo;
import com.example.ntsspringproject.entity.LogInformation;
import com.example.ntsspringproject.repository.LogInformationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogInformationService {
    private final LogInformationRepository logInformationRepository;
    private final ModelMapper modelMapper;

    public void createCommand(String content){
        LogInformation logInformation = new LogInformation();
        logInformation.setContent(content);
        logInformationRepository.save(logInformation);
    }
    public List<LogInformation> getLogs(){
        return logInformationRepository.findAll();
    }



}
