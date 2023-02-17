package com.ders.ornek.controller;

import com.ders.ornek.business.abstracts.CustomerService;
import com.ders.ornek.dto.responseDtos.CustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findallcustomers")
    public ResponseEntity<List<CustomerResponseDto>> findAllCustomers() {
        List<CustomerResponseDto> customerResponseDtos = customerService.findAllCustomers();
        return new ResponseEntity<>(customerResponseDtos, HttpStatus.OK);
    }

}
