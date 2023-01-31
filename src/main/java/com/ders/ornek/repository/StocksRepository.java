package com.ders.ornek.repository;

import com.ders.ornek.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {
    List<Stocks> findAllStocks();

}