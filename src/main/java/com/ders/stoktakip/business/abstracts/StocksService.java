package com.ders.stoktakip.business.abstracts;

import com.ders.stoktakip.dto.requestDtos.StocksRequestDto;
import com.ders.stoktakip.dto.responseDtos.StocksResponseDto;

import java.util.List;

public interface StocksService {
    Long saveStock(StocksRequestDto stocksRequestDto);

    List<StocksResponseDto> findAllStocks();

    Boolean deleteStock(Long stockId);
}
