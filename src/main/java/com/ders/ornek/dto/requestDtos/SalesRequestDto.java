package com.ders.ornek.dto.requestDtos;

import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.Stocks;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SalesRequestDto {
    private Long id;
    private Stocks stock;
    private String salesUnit;
    private double salePrice;
    private double salesAmount;
    private LocalDateTime salesDate;
    private Customer customer;
}
