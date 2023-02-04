package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.StockCategorys;
import com.ders.ornek.entity.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stocks")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "stock_barcode", nullable = true)
    private String barcode;
    @Column(name = "stock_name")
    private String stockName;
    @Column(name = "stock_category")
    @Enumerated(EnumType.STRING)
    private StockCategorys stockCategory;
    @Column(name = "stock_units")
    @Enumerated(EnumType.STRING)
    private Units units;
    @Column(name = "stock_amount")
    private double stockAmount;
    @Column(name = "unit_price")
    private double unitPrice;

}
