package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.StockCategorys;
import com.ders.ornek.entity.enums.StockUnits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "stocks")
//@PrimaryKeyJoinColumn(name = "stock_id")
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private long barcode;
    @Column(name = "stock_name")
    private String stockName;
    @Column(name = "stock_category")
    @Enumerated(EnumType.STRING)
    private StockCategorys stockCategory;
    @Column(name = "stock_units")
    @Enumerated(EnumType.STRING)
    private StockUnits stockUnits;
    @Column(name = "stock_amount")
    private double stockAmount;
    @Column(name = "unit_price")
    private double unitPrice;

}
