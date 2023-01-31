package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.StocksService;
import com.ders.ornek.dto.requestDtos.StocksRequestDto;
import com.ders.ornek.dto.responseDtos.StocksResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StocksManager implements StocksService {
    @Override
    public Long saveStock(StocksRequestDto stocksRequestDto) {
        return null;
    }

    @Override
    public List<StocksResponseDto> findAllStocks() {
        return null;
    }

    @Override
    public Boolean deleteStock(Long stockId) {
        return null;
    }
}
