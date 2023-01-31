package com.ders.ornek.dto.requestDtos;

import lombok.Data;

@Data
public class IndividualCustomerRequestDto {
    private long id;
    private String name;
    private String lastName;
    private double discount;
    private int nationalId;
}
