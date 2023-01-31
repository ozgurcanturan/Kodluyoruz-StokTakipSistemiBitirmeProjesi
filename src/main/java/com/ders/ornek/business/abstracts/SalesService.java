package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.SalesRequestDto;
import com.ders.ornek.dto.responseDtos.SalesResponseDto;

import java.util.List;

public interface SalesService {
    Long saveSales(SalesRequestDto salesRequestDto);

    List<SalesResponseDto> findAllSales();

    List<SalesResponseDto> findAllSalesByCorporateCustomerId(Long corporateCustomerId);

    List<SalesResponseDto> findAllSalesByIndividualCustomerId(Long individualCustomer);

    List<SalesResponseDto> findAllSalesByStockId(Long stockId);

    Boolean deleteSalesById(Long SalesId);
}
