package com.ders.stoktakip.dto.responseDtos;

import com.ders.stoktakip.model.Customer;
import com.ders.stoktakip.model.Sales;
import com.ders.stoktakip.model.Stocks;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductReturnResponseDto {
    private long id;
    private Sales salesId;
    private Customer customer;
    private Stocks stocks;
    private String returnUnits;
    private double productReturnAmount;
    private String productReturnMessage;
    private LocalDateTime returnDate;
}
