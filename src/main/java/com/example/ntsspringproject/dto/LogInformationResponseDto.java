package com.example.ntsspringproject.dto;

import com.example.ntsspringproject.entity.LogInformation;
import jdk.dynalink.linker.LinkerServices;
import lombok.Builder;

import java.util.List;
@Builder
public record LogInformationResponseDto (List<String> content) {
}