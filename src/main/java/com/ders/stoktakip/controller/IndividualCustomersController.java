package com.ders.stoktakip.controller;

import com.ders.stoktakip.business.abstracts.IndividualCustomerService;
import com.ders.stoktakip.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.stoktakip.dto.responseDtos.IndividualCustomerResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class IndividualCustomersController {
    private IndividualCustomerService individualcustomerService;


    @Autowired
    public IndividualCustomersController(IndividualCustomerService individualcustomerService) {
        this.individualcustomerService = individualcustomerService;
    }

    @GetMapping("/findAllIndividualCustomers")
    public ResponseEntity<List<IndividualCustomerResponseDto>> findAllIndividualCustomers() {
        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = individualcustomerService.findAllIndividualCustomers();
        return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/saveIndividualCustomer")
    public ResponseEntity<Long> saveIndividualCustomer(@RequestBody IndividualCustomerRequestDto individualCustomerRequestDto) {
        Long individualCustomerId = individualcustomerService.saveIndividualCustomer(individualCustomerRequestDto);

        return new ResponseEntity<>(individualCustomerId, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIndividualCustomerById")
    public ResponseEntity<Boolean> deleteIndividualCustomerById(@RequestParam Long individualCustomerId) {
        boolean delete = individualcustomerService.deleteIndividualCustomerById(individualCustomerId);
        return new ResponseEntity<>(true, HttpStatus.OK);

    }
}
