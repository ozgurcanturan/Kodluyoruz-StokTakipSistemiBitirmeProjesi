package com.ders.stoktakip.dto.responseDtos;

import lombok.Data;

@Data
public class IndividualCustomerResponseDto {
    private long id;
    private String name;
    private String lastName;
    private double discount;
    private String nationalId;
}
