package com.ders.ornek.controller;

import com.ders.ornek.business.abstracts.SalesService;
import com.ders.ornek.dto.requestDtos.SalesRequestDto;
import com.ders.ornek.dto.responseDtos.SalesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    SalesService salesService;

    @Autowired
    private SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/findAllSales")
    public ResponseEntity<List<SalesResponseDto>> findAllSales() {
        List<SalesResponseDto> salesResponseDtos = salesService.findAllSales();
        return new ResponseEntity<>(salesResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/savaSales")
    public ResponseEntity<Long> saveSales(@RequestBody SalesRequestDto salesRequestDto) {
        Long salesId = salesService.saveSales(salesRequestDto);
        return new ResponseEntity<>(salesId, HttpStatus.OK);
    }

    @GetMapping("/findAllSalesByStockId")
    public ResponseEntity<List<SalesResponseDto>> findAllSalesByStockId(@RequestParam Long stockId) {
        List<SalesResponseDto> salesResponseDtos = salesService.findAllSalesByStockId(stockId);
        return new ResponseEntity<>(salesResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllSalesByCustomerId")
    public ResponseEntity<List<SalesResponseDto>> findAllSalesByCustomerId(@RequestParam Long customerId) {
        List<SalesResponseDto> salesResponseDtos = salesService.findAllSalesByCustomerId(customerId);
        return new ResponseEntity<>(salesResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteSalesById")
    public ResponseEntity<Boolean> deleteSalesById(@RequestParam Long id) {
        boolean isDelete = salesService.deleteSalesById(id);
        if (isDelete)
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
