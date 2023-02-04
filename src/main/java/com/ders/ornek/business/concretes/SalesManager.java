package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.SalesService;
import com.ders.ornek.dto.requestDtos.SalesRequestDto;
import com.ders.ornek.dto.responseDtos.SalesResponseDto;
import com.ders.ornek.entity.Customer;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.entity.Stocks;
import com.ders.ornek.repository.CustomerRepository;
import com.ders.ornek.repository.SalesRepository;
import com.ders.ornek.repository.StocksRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesManager implements SalesService {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StocksRepository stocksRepository;

    @Override
    public Long saveSales(SalesRequestDto salesRequestDto) {
        Sales sales = modelMapper.map(salesRequestDto, Sales.class);
        sales = salesRepository.save(sales);


        return sales.getId();
    }

    @Override
    public List<SalesResponseDto> findAllSales() {
        Iterable<Sales> salesList = salesRepository.findAll();
        List<SalesResponseDto> salesResponseDtos = new ArrayList<>();

        for (Sales sales : salesList) {
            SalesResponseDto salesResponseDto = modelMapper.map(sales, SalesResponseDto.class);
            salesResponseDtos.add(salesResponseDto);

        }
        return salesResponseDtos;
    }

    @Override
    public List<SalesResponseDto> findAllSalesByCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        List<Sales> salesList = salesRepository.findAllSalesByCustomerId(customer);

        List<SalesResponseDto> salesResponseDtos = new ArrayList<>();
        for (Sales sales : salesList) {

            SalesResponseDto salesResponseDto = modelMapper.map(sales, SalesResponseDto.class);
            salesResponseDtos.add(salesResponseDto);
        }


        return salesResponseDtos;
    }


    @Override
    public List<SalesResponseDto> findAllSalesByStockId(Long stockId) {
        Stocks stock = stocksRepository.findById(stockId).get();
        List<Sales> salesList = salesRepository.findAllSalesByStockId(stock);

        List<SalesResponseDto> salesResponseDtos = new ArrayList<>();
        for (Sales sales : salesList) {
            SalesResponseDto salesResponseDto = modelMapper.map(sales, SalesResponseDto.class);
            salesResponseDtos.add(salesResponseDto);

        }
        return salesResponseDtos;
    }

    @Override
    public Boolean deleteSalesById(Long salesId) {
        Sales sales = salesRepository.findById(salesId).get();
        salesRepository.delete(sales);
        return true;
    }
}
