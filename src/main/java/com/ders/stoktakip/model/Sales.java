
package com.ders.stoktakip.model;

import com.ders.stoktakip.model.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
@Data
public class Sales {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id", foreignKey = @ForeignKey(name = "FK_SALES_STOCK"))
    private Stocks stock;
    @Column(name = "sales_unit")
    @Enumerated(EnumType.STRING)
    private Units salesUnit;
    @Column(name = "sales_amount")
    private double salesAmount;
    @Column(name = "sale_price")
    private double salePrice;
    @Column(name = "sales_date")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, style = "dd/MM/yyyy hh:mm", pattern = "dd/MM/yyyy hh:mm")
//    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime salesDate=LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_SALES_CUSTOMER"))
    private Customer customer;


}