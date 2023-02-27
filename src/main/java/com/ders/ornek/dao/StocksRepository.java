package com.ders.ornek.dao;

import com.ders.ornek.model.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StocksRepository extends JpaRepository<Stocks, Long> {
    List<Stocks> findAllStocksById(Stocks stocks);
}