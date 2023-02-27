package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.SalesRequestDto;
import com.ders.ornek.dto.responseDtos.SalesResponseDto;
import com.ders.ornek.model.Sales;

import java.util.List;
import java.util.Optional;

public interface SalesService {
    Optional<Sales> findById(Long id);

    Long saveSales(SalesRequestDto salesRequestDto);

    List<SalesResponseDto> findAllSales();

    List<SalesResponseDto> findAllSalesByCustomerId(Long customerId);


    List<SalesResponseDto> findAllSalesByStockId(Long stockId);

    Boolean deleteSalesById(Long salesId);
}
