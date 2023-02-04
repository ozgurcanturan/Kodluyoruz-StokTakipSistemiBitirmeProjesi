package com.ders.ornek.dto.responseDtos;

import lombok.Data;

@Data
public class CustomerResponseDto {
    private Long id;
    private String name;
    private Long discount;
}
