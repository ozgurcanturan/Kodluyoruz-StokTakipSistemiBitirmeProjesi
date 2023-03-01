package com.ders.stoktakip.dto.responseDtos;

import lombok.Data;

@Data
public class CorporateCustomerResponseDto {
    private long id;
    private String name;
    private double discount;
    private int taxNumber;
    private String address;

}
