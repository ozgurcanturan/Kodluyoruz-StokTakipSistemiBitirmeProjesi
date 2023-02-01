package com.ders.ornek.controller;

import com.ders.ornek.business.abstracts.IndividualCustomerService;
import com.ders.ornek.dto.requestDtos.IndividualCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.IndividualCustomerResponseDto;
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

    @GetMapping("/findAllIndividualCustomersByReturnId")
    public ResponseEntity<List<IndividualCustomerResponseDto>> findAllIndividualCustomersByReturnId(@RequestParam Long returnId) {
        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = individualcustomerService.findAllIndividualCustomersByReturnId(returnId);
        return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
    }


    @GetMapping("/findAllIndividualCustomersBySalesId")
    public ResponseEntity<List<IndividualCustomerResponseDto>> findAllIndividualCustomersBySalesId(@RequestParam Long salesId) {
        List<IndividualCustomerResponseDto> individualCustomerResponseDtos = individualcustomerService.findAllIndividualCustomersBySalesId(salesId);
        return new ResponseEntity<>(individualCustomerResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteIndividualCustomerById")
    public ResponseEntity<Boolean> deleteIndividualCustomerById(@RequestParam Long individualCustomerId) {
        boolean delete = individualcustomerService.deleteIndividualCustomerById(individualCustomerId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
