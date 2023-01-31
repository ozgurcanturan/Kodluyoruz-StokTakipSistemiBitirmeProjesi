package com.ders.ornek.dto.requestDtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SalesRequestDto {
    private long id;
    private long stockId;
    private String salesUnit;
    private double salesAmount;
    private LocalDate salesDate;
    private long customerId;
}
