package com.ders.ornek.dto.requestDtos;

import com.ders.ornek.entity.Customer;
import lombok.Data;

@Data
public class CustomerRequestDto {
    private Long id;
    private String name;
    private Double discount;
}
