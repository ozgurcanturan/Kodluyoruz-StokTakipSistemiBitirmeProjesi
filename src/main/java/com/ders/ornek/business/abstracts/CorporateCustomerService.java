package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.requestDtos.CorporateCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.CorporateCustomerResponseDto;

import java.util.List;

public interface CorporateCustomerService {
    Long saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto);
    List<CorporateCustomerResponseDto> findAllCorporateCustomers();
    boolean deleteCorporateCustomerById(Long corporateCustomerId);
}
