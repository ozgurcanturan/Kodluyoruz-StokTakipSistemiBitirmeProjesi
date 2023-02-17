package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.StocksService;
import com.ders.ornek.dto.requestDtos.StocksRequestDto;
import com.ders.ornek.dto.responseDtos.StocksResponseDto;
import com.ders.ornek.entity.Stocks;
import com.ders.ornek.exceptions.StockNotFoundException;
import com.ders.ornek.repository.StocksRepository;
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
