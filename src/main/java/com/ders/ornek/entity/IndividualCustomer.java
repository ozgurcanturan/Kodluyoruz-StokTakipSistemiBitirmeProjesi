package com.ders.ornek.entity;

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
public class IndividualCustomer extends Customer {
    @Column(name = "national_id",unique = true)
    private String nationalId;
    @Column(name = "last_name")
    private String lastName;

}
