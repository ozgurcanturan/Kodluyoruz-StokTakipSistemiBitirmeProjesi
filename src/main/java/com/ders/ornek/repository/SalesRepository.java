package com.ders.ornek.repository;


import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findAllSalesByCustomerId(Optional<Customer> customer);

    List<Sales> findAllSalesByStockId(Stocks stocks);
}