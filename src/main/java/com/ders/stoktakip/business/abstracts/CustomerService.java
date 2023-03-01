package com.ders.stoktakip.business.abstracts;

import com.ders.stoktakip.dto.responseDtos.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
List<CustomerResponseDto> findAllCustomers();
}
