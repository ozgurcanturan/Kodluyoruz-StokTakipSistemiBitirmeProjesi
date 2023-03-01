package com.ders.stoktakip.controller;

import com.ders.stoktakip.business.abstracts.ProductReturnService;
import com.ders.stoktakip.dto.requestDtos.ProductReturnRequestDto;
import com.ders.stoktakip.dto.responseDtos.ProductReturnResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productreturns")
public class ProductReturnController {
    ProductReturnService productReturnService;

    @Autowired
    private ProductReturnController(ProductReturnService productReturnService) {
        this.productReturnService = productReturnService;
    }

    @GetMapping("/findAllProductReturns")
    public ResponseEntity<List<ProductReturnResponseDto>> findAllProductReturns() {
        List<ProductReturnResponseDto> productReturnResponseDtos = productReturnService.findAllProductReturn();
        return new ResponseEntity<>(productReturnResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/saveProductReturn")
    public ResponseEntity<Long> saveProductReturn(@RequestBody ProductReturnRequestDto productReturnRequestDto) {
        Long productReturnId = productReturnService.saveProductReturn(productReturnRequestDto);
        return new ResponseEntity<>(productReturnId, HttpStatus.OK);
    }

    @GetMapping("/findAllProductReturnsByCustomerId")
    public ResponseEntity<List<ProductReturnResponseDto>> findAllProductReturnsByCustomerId(@RequestParam Long customerId) {
        List<ProductReturnResponseDto> productReturnResponseDtos = productReturnService.findAllProductReturnByCustomerId(customerId);
        return new ResponseEntity<>(productReturnResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllProductReturnsByStockId")
    public ResponseEntity<List<ProductReturnResponseDto>> findAllProductReturnsByStockId(@RequestParam Long stockId) {
        List<ProductReturnResponseDto> productReturnResponseDtos = productReturnService.findAllProductReturnByStockId(stockId);
        return new ResponseEntity<>(productReturnResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductReturnById")
    public ResponseEntity<Boolean> deleteProductReturnById(@RequestParam Long id) {
        boolean delete = productReturnService.DeleteProductReturnById(id);

        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

}
