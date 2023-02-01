package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.ProductReturnService;
import com.ders.ornek.dto.requestDtos.ProductReturnRequestDto;
import com.ders.ornek.dto.responseDtos.ProductReturnResponseDto;
import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.ProductReturn;
import com.ders.ornek.entity.Stocks;
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
        Iterable<ProductReturn> productReturnsList = productReturnRepository.findAll();
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
        Customer customer = customerRepository.findById(customerId).get();
        List<ProductReturn> productReturnList = productReturnRepository.findAllProductReturnsByCustomerId(customer);

        List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
        for (ProductReturn productReturn : productReturnList) {
            ProductReturnResponseDto productReturnResponseDto = modelMapper.map(productReturn, ProductReturnResponseDto.class);
            productReturnResponseDtos.add(productReturnResponseDto);
        }

        return productReturnResponseDtos;
    }

    @Override
    public List<ProductReturnResponseDto> findAllProductReturnByStockId(Long stockId) {
        Stocks stock = stocksRepository.findById(stockId).get();
        List<ProductReturn> productReturnList = productReturnRepository.findAllProductReturnsByStocksId(stock);

        List<ProductReturnResponseDto> productReturnResponseDtos = new ArrayList<>();
        for (ProductReturn productReturn : productReturnList) {
            ProductReturnResponseDto productReturnResponseDto = modelMapper.map(productReturn, ProductReturnResponseDto.class);
            productReturnResponseDtos.add(productReturnResponseDto);
        }
        return productReturnResponseDtos;
    }

    @Override
    public Boolean DeleteProductReturnById(Long productReturnId) {
        if (productReturnId > 0) {
            ProductReturn productReturn = productReturnRepository.findById(productReturnId).get();
            productReturnRepository.delete(productReturn);
            //deleteById dene

            return true;
        } else {
            return false;
        }
    }
}
