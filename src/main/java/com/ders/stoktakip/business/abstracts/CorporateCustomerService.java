package com.ders.stoktakip.business.abstracts;

import com.ders.stoktakip.dto.requestDtos.CorporateCustomerRequestDto;
import com.ders.stoktakip.dto.responseDtos.CorporateCustomerResponseDto;

import java.util.List;

public interface CorporateCustomerService {
    Long saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto);
    List<CorporateCustomerResponseDto> findAllCorporateCustomers();
    boolean deleteCorporateCustomerById(Long corporateCustomerId);
}
