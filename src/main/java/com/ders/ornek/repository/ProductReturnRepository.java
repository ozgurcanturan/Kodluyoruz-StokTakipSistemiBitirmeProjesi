package com.ders.ornek.repository;

import com.ders.ornek.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReturnRepository extends JpaRepository<ProductReturn, Long> {

    List<ProductReturn> findAllProductReturnsByCustomerId(Customer customer);

    List<ProductReturn> findAllProductReturnsByIndividualStockId(Stocks stocks);
}