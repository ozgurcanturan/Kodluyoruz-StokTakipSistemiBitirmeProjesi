package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.model.ProductReturn;

import java.util.List;
import java.util.Optional;

public interface ProductReturnService {
    Optional<ProductReturn> findById(Long id);

    List<ProductReturnResponseDto> findAllProductReturn();

    Long saveProductReturn(ProductReturnRequestDto productReturnRequestDto);

    List<ProductReturnResponseDto> findAllProductReturnByCustomerId(Long customerId);

    List<ProductReturnResponseDto> findAllProductReturnByStockId(Long stockId);

    Boolean DeleteProductReturnById(Long productReturnId);
}
