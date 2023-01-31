package com.ders.ornek.dto.responseDtos;

import lombok.Data;

@Data
public class ProductReturnResponseDto {
    private long id;
    private long salesId;
    private String returnUnits;
    private double productReturnAmount;
    private String productReturnMessage;
}
