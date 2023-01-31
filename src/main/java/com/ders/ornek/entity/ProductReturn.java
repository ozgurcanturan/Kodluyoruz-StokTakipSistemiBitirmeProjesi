package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.StockUnits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_return")
public class ProductReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sales_id", foreignKey = @ForeignKey(name = "FK_SALES_RETURN"))
    private Sales salesId;
    @ManyToOne
    @JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name = "FK_CUSTOMER_RETURN"))
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "stocks_id",foreignKey = @ForeignKey(name = "FK_STOCKS_RETURN"))
    private Stocks stocks;
    @Column(name = "return_units")
    @Enumerated(EnumType.STRING)
    private StockUnits returnUnits;
    @Column(name = "product_return_amount")
    private double productReturnAmount;
    @Column(name = "product_return_message")
    private String productReturnMessage;

}
