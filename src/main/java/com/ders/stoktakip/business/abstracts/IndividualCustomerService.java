package com.ders.stoktakip.business.abstracts;

import com.ders.stoktakip.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.stoktakip.dto.responseDtos.IndividualCustomerResponseDto;
import com.ders.stoktakip.model.IndividualCustomer;

import java.util.List;

public interface IndividualCustomerService {
    IndividualCustomer findById(Long id);
    Long saveIndividualCustomer(IndividualCustomerRequestDto individualCustomerRequestDto);

    List<IndividualCustomerResponseDto> findAllIndividualCustomers();

    boolean deleteIndividualCustomerById(Long individualCustomerId);
}
