package com.ders.ornek.dto.requestDtos;

import lombok.Data;

@Data
public class CustomerRequestDto {
    private Long id;
    private String name;
    private Double discount;
}
