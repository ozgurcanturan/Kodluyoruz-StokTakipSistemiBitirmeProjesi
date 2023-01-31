package com.ders.ornek.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
//@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")

public class CorporateCustomer extends Customer {
    @Column(name = "tax_number",unique = true)
    private int taxNumber;
    @Column
    private String address;
}
