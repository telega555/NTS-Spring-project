package com.example.ntsspringproject.dto;

import lombok.Builder;

@Builder
public record LogInformationRequestDto(String command,
                                       String content) {
}