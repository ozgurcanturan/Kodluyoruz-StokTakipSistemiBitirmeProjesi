package com.ders.ornek.repository;

import com.ders.ornek.entity.IndividualCustomer;
import com.ders.ornek.entity.ProductReturn;
import com.ders.ornek.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Long> {
}