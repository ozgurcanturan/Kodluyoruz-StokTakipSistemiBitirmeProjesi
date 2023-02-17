package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.ProductReturnService;
import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.entity.ProductReturn;
import com.ders.ornek.repository.CustomerRepository;
import com.ders.ornek.repository.ProductReturnRepository;
import com.ders.ornek.repository.StocksRepository;
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

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StocksRepository stocksRepository;


    @Override
    public List<ProductReturnResponseDto> findAllProductReturn() {
        List<ProductReturn> productReturnsList = productReturnRepository.findAll();
        List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
        for (ProductReturn productReturn : productReturnsList) {
            ProductReturnResponseDto productReturnResponseDto = modelMapper.map(productReturn, ProductReturnResponseDto.class);
            productReturnResponseDtos.add(productReturnResponseDto);

        }
        return productReturnResponseDtos;
    }

    @Override
    public Long saveProductReturn(ProductReturnRequestDto productReturnRequestDto) {
        ProductReturn productReturn = modelMapper.map(productReturnRequestDto, ProductReturn.class);
        productReturn = productReturnRepository.save(productReturn);
        return productReturn.getId();
    }

    @Override
    public List<ProductReturnResponseDto> findAllProductReturnByCustomerId(Long customerId) {
        List<ProductReturn> productReturnList = productReturnRepository.findAllProductReturnsByCustomerId(customerId);

        List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
        for (ProductReturn productReturn : productReturnList) {
            ProductReturnResponseDto productReturnResponseDto = modelMapper.map(productReturn, ProductReturnResponseDto.class);
            productReturnResponseDtos.add(productReturnResponseDto);
        }

        return productReturnResponseDtos;
    }

    @Override
    public List<ProductReturnResponseDto> findAllProductReturnByStockId(Long stockId) {
        List<ProductReturn> productReturnList = productReturnRepository.findAllProductReturnsByStocksId(stockId);
        if (!productReturnList.isEmpty()) {
            List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
            for (ProductReturn productReturn : productReturnList) {
                ProductReturnResponseDto productReturnResponseDto = modelMapper.map(productReturn, ProductReturnResponseDto.class);
                productReturnResponseDtos.add(productReturnResponseDto);
            }
            return productReturnResponseDtos;
        }
        return null;
    }

    @Override
    public Boolean DeleteProductReturnById(Long productReturnId) {
        if (productReturnId > 0) {
            productReturnRepository.deleteById(productReturnId);
            return true;
        } else {
            return false;
        }
    }
}
