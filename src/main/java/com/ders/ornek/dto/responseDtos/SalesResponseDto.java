package com.ders.ornek.dto.responseDtos;

import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.Stocks;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SalesResponseDto {
    private long id;
    private Stocks stock;
    private String salesUnit;
    private double salesAmount;
    private double salePrice;
    private LocalDateTime salesDate;
    private Customer customerId;
}
