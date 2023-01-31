package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.SalesService;
import com.ders.ornek.dto.requestDtos.SalesRequestDto;
import com.ders.ornek.dto.responseDtos.SalesResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalesManager implements SalesService {
    @Override
    public Long saveSales(SalesRequestDto salesRequestDto) {
        return null;
    }

    @Override
    public List<SalesResponseDto> findAllSales() {
        return null;
    }

    @Override
    public List<SalesResponseDto> findAllSalesByCorporateCustomerId(Long corporateCustomerId) {
        return null;
    }

    @Override
    public List<SalesResponseDto> findAllSalesByIndividualCustomerId(Long individualCustomer) {
        return null;
    }

    @Override
    public List<SalesResponseDto> findAllSalesByStockId(Long stockId) {
        return null;
    }

    @Override
    public Boolean deleteSalesById(Long SalesId) {
        return null;
    }
}
