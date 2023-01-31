package com.ders.ornek.dto.requestDtos;

import lombok.Data;

@Data
public class ProductReturnRequestDto {
    private long id;
    private long salesId;
    private String returnUnits;
    private double productReturnAmount;
    private String productReturnMessage;
}
