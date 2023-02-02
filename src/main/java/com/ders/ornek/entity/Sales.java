package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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
    private Units salesUnit;
    @Column(name = "sales_amount")
    private double salesAmount;
    @Column(name="sale_price")
    private double salePrice;
    @Column(name = "sales_date")
    private LocalDate salesDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_SALES_CUSTOMER"))
    private Customer customer;
//    @OneToMany(mappedBy = "id")
//    private List<Stocks> stocks;
}
