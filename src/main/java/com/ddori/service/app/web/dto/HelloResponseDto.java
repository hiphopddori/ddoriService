package com.ddori.service.app.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class HelloResponseDto {
    private  String name;
    private int amount;
}
