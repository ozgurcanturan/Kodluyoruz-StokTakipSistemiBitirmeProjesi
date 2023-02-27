package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;
import com.ders.ornek.model.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    IndividualCustomer findById(Long id);
    Long saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

    List<IndividualCustomerResponseDto> findAllIndividualCustomers();

    boolean deleteIndividualCustomerById(Long individualCustomerId);
}
