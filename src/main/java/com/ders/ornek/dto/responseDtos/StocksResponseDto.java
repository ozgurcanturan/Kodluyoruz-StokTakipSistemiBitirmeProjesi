package com.ders.ornek.dto.responseDtos;

import com.ders.ornek.model.enums.Units;
import lombok.Data;

@Data
public class StocksResponseDto {
    private long id;
    private String barcode;
    private String stockName;
    private String stockCategory;
    private Units units;
    private double stockAmount;
    private double unitPrice;
}
