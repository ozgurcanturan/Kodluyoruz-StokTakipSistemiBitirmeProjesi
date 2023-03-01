package com.ders.stoktakip.business.concretes;

import com.ders.stoktakip.business.abstracts.StocksService;
import com.ders.stoktakip.dto.requestDtos.StocksRequestDto;
import com.ders.stoktakip.dto.responseDtos.StocksResponseDto;
import com.ders.stoktakip.model.Stocks;
import com.ders.stoktakip.exceptions.StockNotFoundException;
import com.ders.stoktakip.dao.StocksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StocksManager implements StocksService {
    @Autowired
    private StocksRepository stocksRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Long saveStock(StocksRequestDto stocksRequestDto) {
        Stocks stocks = modelMapper.map(stocksRequestDto, Stocks.class);
        stocks = stocksRepository.save(stocks);
        return stocks.getId();
    }

    @Override
    public List<StocksResponseDto> findAllStocks() {
        Iterable<Stocks> stocksList = stocksRepository.findAll();
        List<StocksResponseDto> stocksResponseDtos = new ArrayList<>();
        for (Stocks stocks : stocksList) {
            StocksResponseDto stocksResponseDto = modelMapper.map(stocks, StocksResponseDto.class);
            stocksResponseDtos.add(stocksResponseDto);

        }
        return stocksResponseDtos;
    }

    @Override
    public Boolean deleteStock(Long stockId) {
        Stocks stocks = stocksRepository.findById(stockId).orElseThrow(() -> new StockNotFoundException("Hata yakalandı, ID " + stockId + " bulunamadı.")
        );



        stocksRepository.deleteById(stockId);
        return true;
    }

}
