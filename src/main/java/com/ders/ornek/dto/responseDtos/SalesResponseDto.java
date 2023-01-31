package com.ders.ornek.dto.responseDtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SalesResponseDto {
    private long id;
    private long stockId;
    private String salesUnit;
    private double salesAmount;
    private LocalDate salesDate;
    private long customerId;
}
