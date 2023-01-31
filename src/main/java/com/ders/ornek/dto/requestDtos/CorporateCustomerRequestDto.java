package com.ders.ornek.dto.requestDtos;

import lombok.Data;

@Data
public class CorporateCustomerRequestDto {
    private long id;
    private String name;
    private double discount;
    private int taxNumber;
    private String address;

}
