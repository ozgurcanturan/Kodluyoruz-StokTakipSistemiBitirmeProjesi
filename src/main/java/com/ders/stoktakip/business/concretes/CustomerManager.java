package com.ders.stoktakip.business.concretes;

import com.ders.stoktakip.business.abstracts.CustomerService;
import com.ders.stoktakip.dto.responseDtos.CustomerResponseDto;
import com.ders.stoktakip.model.Customer;
import com.ders.stoktakip.dao.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerResponseDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerResponseDto customerResponseDto = modelMapper.map(customer, CustomerResponseDto.class);
            customerResponseDtos.add(customerResponseDto);
        }


        return customerResponseDtos;
    }

}
