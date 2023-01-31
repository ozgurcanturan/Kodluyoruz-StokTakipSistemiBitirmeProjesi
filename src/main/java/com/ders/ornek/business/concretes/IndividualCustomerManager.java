package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.IndividualCustomerService;
import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;
import com.ders.ornek.entity.IndividualCustomer;
import com.ders.ornek.entity.ProductReturn;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.repository.IndividualCustomerRepository;
import com.ders.ornek.repository.ProductReturnRepository;
import com.ders.ornek.repository.SalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class IndividualCustomerManager implements IndividualCustomerService {
    @Autowired
    private IndividualCustomerRepository individualCustomerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductReturnRepository productReturnRepository;

    @Override
    public Long saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto) {
        IndividualCustomer individualCustomer = modelMapper.map(individualCustomerRequestDto, IndividualCustomer.class);
        individualCustomer = individualCustomerRepository.save(individualCustomer);
        return individualCustomer.getId();
    }

    @Override
    public List<IndividualCustomerResponseDto> findAllIndividualCustomers() {
        Iterable<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();
        for (IndividualCustomer individualCustomer : individualCustomers) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }
        return individualCustomerResponseDtos;
    }

    @Override
    public List<IndividualCustomerResponseDto> findAllIndividualCustomersBySalesId(Long salesId) {
        Sales sales = salesRepository.findById(salesId).get();
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAllIndividualCustomersById(sales);

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();

        for (IndividualCustomer individualCustomer : individualCustomerList) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }

        return individualCustomerResponseDtos;
    }

    @Override
    public List<IndividualCustomerResponseDto> findAllIndividualCustomersByReturnId(Long productReturnId) {
        ProductReturn productReturn = productReturnRepository.findById(productReturnId).get();
        List<IndividualCustomer> individualCustomerList = individualCustomerRepository.findAllIndividualCustomersById(productReturn);

        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = new ArrayList<>();

        for (IndividualCustomer individualCustomer : individualCustomerList) {
            IndividualCustomerResponseDto individualCustomerResponseDto = modelMapper.map(individualCustomer, IndividualCustomerResponseDto.class);
            individualCustomerResponseDtos.add(individualCustomerResponseDto);
        }

        return individualCustomerResponseDtos;
    }

    @Override
    public boolean deleteIndividualCustomerById(Long individualCustomerId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(individualCustomerId).get();
        individualCustomerRepository.delete(individualCustomer);
        return true;
    }
}
