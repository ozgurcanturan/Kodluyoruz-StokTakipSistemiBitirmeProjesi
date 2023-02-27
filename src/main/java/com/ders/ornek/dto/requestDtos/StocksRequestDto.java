package com.ders.ornek.dto.requestDtos;

import com.ders.ornek.model.enums.Units;
import lombok.Data;

@Data
public class StocksRequestDto {
    private long id;
    private String barcode;
    private String stockName;
    private String stockCategory;
    private Units units;
    private double stockAmount;
    private double unitPrice;
}
