package com.ders.ornek.dto.responseDtos;

import lombok.Data;

@Data
public class StocksResponseDto {
    private long id;
    private long barcode;
    private String stockName;
    private String stockCategory;
    private String stockUnits;
    private double stockAmount;
    private double unitPrice;
}
