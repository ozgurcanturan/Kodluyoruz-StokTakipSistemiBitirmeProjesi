package com.ders.ornek.dao;


import com.ders.ornek.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    List<Sales> findAllSalesByCustomerId(Long customerId);

    List<Sales> findAllSalesByStockId(Long stockId);
}