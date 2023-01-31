package com.ders.ornek.controller;

import com.ders.ornek.business.abstracts.CorporateCustomerService;
import com.ders.ornek.dto.requestDtos.CorporateCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.CorporateCustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporateCustomers")
public class CorporateCustomersController {

    private CorporateCustomerService corporateCustomerService;

    @Autowired
    public CorporateCustomersController(CorporateCustomerService corporateCustomerService) {
        this.corporateCustomerService = corporateCustomerService;
    }

    @PostMapping("/saveCorporateCustomer")
    public ResponseEntity<Long> saveCorporateCustomer(@RequestBody CorporateCustomerRequestDto corporateCustomerRequestDto) {
        Long corporateCustomerId = corporateCustomerService.saveCorporateCustomer(corporateCustomerRequestDto);
        return new ResponseEntity<>(corporateCustomerId, HttpStatus.OK);
    }

    @GetMapping("/findAllCorporateCustomers")
    public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomers() {
        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomers();
        return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllCorporateCustomersByReturnId")
    public ResponseEntity<List<CorporateCustomerResponseDto>> findAllCorporateCustomersById(@RequestParam Long returnId) {
        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = corporateCustomerService.findAllCorporateCustomersByReturnId(returnId);
        return new ResponseEntity<>(corporateCustomerResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCorporateCustomerById")
    public ResponseEntity<Boolean> deleteCorporateCustomerById(@RequestParam Long corporateCustomerId) {
        boolean delete = corporateCustomerService.deleteCorporateCustomerById(corporateCustomerId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
