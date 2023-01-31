package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.ProductReturnService;
import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.entity.ProductReturn;
import com.ders.ornek.repository.ProductReturnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductReturnManager implements ProductReturnService {
    @Autowired
    ProductReturnRepository productReturnRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ProductReturnResponseDto> findAllProductReturn() {
        Iterable<ProductReturn> productReturnsList = productReturnRepository.findAll();
        List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
        for (ProductReturn productReturn : productReturnsList) {
            ProductReturnResponseDto productReturnResponseDto=modelMapper.map(productReturn,ProductReturnResponseDto.class);
            productReturnResponseDtos.add(productReturnResponseDto);

        }
        return productReturnResponseDtos;
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
