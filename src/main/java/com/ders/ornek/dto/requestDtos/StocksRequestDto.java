package com.ders.ornek.dto.requestDtos;

import lombok.Data;

@Data
public class StocksRequestDto {
    private long id;
    private String barcode;
    private String stockName;
    private String stockCategory;
    private String stockUnits;
    private double stockAmount;
    private double unitPrice;
}
