package com.ders.ornek.repository;

import com.ders.ornek.entity.CorporateCustomer;
import com.ders.ornek.entity.IndividualCustomer;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findAllSalesByCorporateCustomerId(CorporateCustomer corporateCustomer);

    List<Sales> findAllSalesByIndividualCustomerId(IndividualCustomer individualCustomer);
    List<Sales> findAllSalesByStockId(Stocks stocks);
}