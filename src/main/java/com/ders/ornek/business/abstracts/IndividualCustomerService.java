package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;

import java.util.List;

public interface IndividualCustomerService {
    Long saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

    List<IndividualCustomerResponseDto> findAllIndividualCustomers();

    boolean deleteIndividualCustomerById(Long individualCustomerId);
}
