package com.ders.ornek.entity;

import com.ders.ornek.entity.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name = "FK_CUSTOMER_RETURN"))
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stocks_id",foreignKey = @ForeignKey(name = "FK_STOCKS_RETURN"))
    private Stocks stocks;
    @Column(name = "return_units")
    @Enumerated(EnumType.STRING)
    private Units returnUnits;
    @Column(name = "product_return_amount")
    private double productReturnAmount;
    @Column(name = "product_return_message")
    private String productReturnMessage;

}
