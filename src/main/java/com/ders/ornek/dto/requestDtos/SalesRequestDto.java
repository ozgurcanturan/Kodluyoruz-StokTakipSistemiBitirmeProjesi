package com.ders.ornek.dto.requestDtos;

import com.ders.ornek.model.Customer;
import com.ders.ornek.model.Stocks;
import lombok.Data;

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
