package com.ders.stoktakip.dao;


import com.ders.stoktakip.model.ProductReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReturnRepository extends JpaRepository<ProductReturn, Long> {

    List<ProductReturn> findAllProductReturnsByCustomerId(Long customerId);

    List<ProductReturn> findAllProductReturnsByStocksId(Long stocksId);
}