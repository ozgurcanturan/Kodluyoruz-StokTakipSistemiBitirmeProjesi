package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.repository.ProductReturnRepository;

import java.util.List;

public interface ProductReturnService {
    List<ProductReturnResponseDto> findAllProductReturn();

    Long saveProductReturn(ProductReturnRequestDto productReturnRequestDto);

    List<ProductReturnResponseDto> findAllProductReturnByCustomerId(Long customerId);

    List<ProductReturnResponseDto> findAllProductReturnByStockId(Long stockId);
    Boolean DeleteProductReturnById(Long productReturnId);
}
