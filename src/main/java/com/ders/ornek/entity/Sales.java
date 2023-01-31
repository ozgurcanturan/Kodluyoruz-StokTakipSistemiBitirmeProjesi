package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.StockUnits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sales")
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
    private StockUnits salesUnits;
    @Column(name = "sales_amount")
    private double salesAmount;
    @Column(name = "sales_date")
    private LocalDate salesDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_SALES_CUSTOMER"))
    private Customer customer;
//    @OneToMany(mappedBy = "id")
//    private List<Stocks> stocks;
}
