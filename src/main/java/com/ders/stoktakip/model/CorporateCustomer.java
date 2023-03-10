package com.ders.stoktakip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "customer_id")

public class CorporateCustomer extends Customer {
    @Column(name = "tax_number", unique = true)
    private int taxNumber;
    @Column
    private String address;
}
