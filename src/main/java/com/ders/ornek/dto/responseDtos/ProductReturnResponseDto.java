package com.ders.ornek.dto.responseDtos;

import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.entity.Stocks;
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
