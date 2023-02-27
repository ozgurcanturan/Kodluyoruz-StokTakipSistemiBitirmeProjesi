package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.IndividualCustomerService;
import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;
import com.ders.ornek.model.IndividualCustomer;
import com.ders.ornek.exceptions.CustomerNotFoundException;
import com.ders.ornek.dao.IndividualCustomerRepository;
import com.ders.ornek.dao.ProductReturnRepository;
import com.ders.ornek.dao.SalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public IndividualCustomer findById(Long id) {

        IndividualCustomer individualCustomer = individualCustomerRepository.getReferenceById(id);
        return individualCustomer;
    }

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
    public boolean deleteIndividualCustomerById(Long individualCustomerId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(individualCustomerId).orElseThrow(() -> new CustomerNotFoundException("Hata yakalandı, ID " + individualCustomerId + " bulunamadı."));
        individualCustomerRepository.deleteById(individualCustomerId);
        return true;
    }
}
