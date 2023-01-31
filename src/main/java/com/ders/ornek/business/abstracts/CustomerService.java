package com.ders.ornek.business.abstracts;

import com.ders.ornek.dto.responseDtos.CorporateCustomerResponseDto;
import com.ders.ornek.dto.responseDtos.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
List<CustomerResponseDto> findAllCustomers();
}
