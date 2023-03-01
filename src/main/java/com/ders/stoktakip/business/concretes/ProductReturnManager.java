package com.ders.stoktakip.business.concretes;

import com.ders.stoktakip.business.abstracts.ProductReturnService;
import com.ders.stoktakip.dto.requestDtos.ProductReturnRequestDto;
import com.ders.stoktakip.dto.responseDtos.ProductReturnResponseDto;
import com.ders.stoktakip.model.ProductReturn;
import com.ders.stoktakip.exceptions.ProductReturnNotFoundException;
import com.ders.stoktakip.dao.CustomerRepository;
import com.ders.stoktakip.dao.ProductReturnRepository;
import com.ders.stoktakip.dao.StocksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<ProductReturn> findById(Long id) {
        Optional<ProductReturn> productReturn = productReturnRepository.findById(id);
        return productReturn;
    }

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
        ProductReturn productReturn = productReturnRepository.findById(productReturnId).orElseThrow(() -> new ProductReturnNotFoundException("Hata yakalandı, ID " + productReturnId + " bulunamadı."));
            productReturnRepository.deleteById(productReturnId);
            return true;
    }
}
