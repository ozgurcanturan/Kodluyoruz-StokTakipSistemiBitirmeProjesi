package com.ders.stoktakip.model;

import com.ders.stoktakip.model.enums.Units;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
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
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_CUSTOMER_RETURN"))
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stocks_id", foreignKey = @ForeignKey(name = "FK_STOCKS_RETURN"))
    private Stocks stocks;
    @Column(name = "return_units")
    @Enumerated(EnumType.STRING)
    private Units returnUnits;
    @Column(name = "product_return_amount")
    private double productReturnAmount;
    @Column(name = "product_return_message")
    private String productReturnMessage;
    @Column(name = "return_date")
    private LocalDateTime returnDate;

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        returnDate = LocalDateTime.now();
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sales getSalesId() {
        return salesId;
    }

    public void setSalesId(Sales salesId) {
        this.salesId = salesId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Stocks getStocks() {
        return stocks;
    }

    public void setStocks(Stocks stocks) {
        this.stocks = stocks;
    }

    public Units getReturnUnits() {
        return returnUnits;
    }

    public void setReturnUnits(Units returnUnits) {
        this.returnUnits = returnUnits;
    }

    public double getProductReturnAmount() {
        return productReturnAmount;
    }

    public void setProductReturnAmount(double productReturnAmount) {
        this.productReturnAmount = productReturnAmount;
    }

    public String getProductReturnMessage() {
        return productReturnMessage;
    }

    public void setProductReturnMessage(String productReturnMessage) {
        this.productReturnMessage = productReturnMessage;
    }
}
