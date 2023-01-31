package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.ProductReturnService;
import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.repository.ProductReturnRepository;

import java.util.List;

public class ProductReturnManager implements ProductReturnService {

    @Override
    public List<ProductReturnResponseDto> findAllProductReturn() {
        return null;
    }

    @Override
    public Long saveProductReturn(ProductReturnRequestDto productReturnRequestDto) {
        return null;
    }

    @Override
    public List<ProductReturnRepository> findAllProductReturnByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public List<ProductReturnRepository> findAllProductReturnByStockId(Long stockId) {
        return null;
    }
}
