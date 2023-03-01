package com.ders.stoktakip.business.concretes;

import com.ders.stoktakip.business.abstracts.SalesService;
import com.ders.stoktakip.dto.requestDtos.SalesRequestDto;
import com.ders.stoktakip.dto.responseDtos.SalesResponseDto;
import com.ders.stoktakip.model.Sales;
import com.ders.stoktakip.exceptions.SalesNotFoundException;
import com.ders.stoktakip.dao.CustomerRepository;
import com.ders.stoktakip.dao.SalesRepository;
import com.ders.stoktakip.dao.StocksRepository;
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
    public Optional<Sales> findById(Long id) {
        Optional<Sales> sales = salesRepository.findById(id);
        return sales;
    }

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
        List<Sales> salesList = salesRepository.findAllSalesByCustomerId(customerId);

        List<SalesResponseDto> salesResponseDtos = new ArrayList<>();
        for (Sales sales : salesList) {

            SalesResponseDto salesResponseDto = modelMapper.map(sales, SalesResponseDto.class);
            salesResponseDtos.add(salesResponseDto);

        }


        return salesResponseDtos;
    }


    @Override
    public List<SalesResponseDto> findAllSalesByStockId(Long stockId) {

        List<Sales> salesList = salesRepository.findAllSalesByStockId(stockId);

        List<SalesResponseDto> salesResponseDtos = new ArrayList<>();
        for (Sales sales : salesList) {
            SalesResponseDto salesResponseDto = modelMapper.map(sales, SalesResponseDto.class);
            salesResponseDtos.add(salesResponseDto);

        }
        return salesResponseDtos;
    }

    @Override
    public Boolean deleteSalesById(Long salesId) {
        Sales sales = salesRepository.findById(salesId).orElseThrow(() -> new SalesNotFoundException("Hata yakalandı, ID " + salesId + " bulunamadı."));
        salesRepository.deleteById(salesId);

        return true;

    }
}
