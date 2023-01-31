package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;

import java.util.List;

public interface IndividualCustomerService {
    Long saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

    List<IndividualCustomerResponseDto> findAllIndividualCustomers();

    List<IndividualCustomerResponseDto> findAllIndividualCustomersBySalesId(Long salesId);

    List<IndividualCustomerResponseDto> findAllIndividualCustomersByReturnId(Long productReturnId);

    boolean deleteIndividualCustomerById(Long individualCustomerId);
}
