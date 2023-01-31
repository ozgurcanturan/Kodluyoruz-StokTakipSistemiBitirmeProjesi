package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.StocksRequestDto;
import com.ders.ornek.dto.responseDtos.StocksResponseDto;

import java.util.List;

public interface StocksService {
    Long saveStock(StocksRequestDto stocksRequestDto);
    List<StocksResponseDto> findAllStocks();

    Boolean deleteStock(Long stockId);
}
