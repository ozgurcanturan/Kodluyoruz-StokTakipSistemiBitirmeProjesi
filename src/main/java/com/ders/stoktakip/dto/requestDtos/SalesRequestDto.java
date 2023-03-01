package com.ders.stoktakip.dto.requestDtos;

import com.ders.stoktakip.model.Customer;
import com.ders.stoktakip.model.Stocks;
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
