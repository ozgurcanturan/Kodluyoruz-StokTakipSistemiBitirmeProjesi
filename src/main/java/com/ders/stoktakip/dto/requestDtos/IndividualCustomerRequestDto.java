package com.ders.stoktakip.dto.requestDtos;

import lombok.Data;

@Data
public class IndividualCustomerRequestDto {
    private long id;
    private String name;
    private String lastName;
    private double discount;
    private String nationalId;
}
