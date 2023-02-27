package com.ders.ornek.controller;

import com.ders.ornek.business.abstracts.StocksService;
import com.ders.ornek.dto.requestDtos.StocksRequestDto;
import com.ders.ornek.dto.responseDtos.StocksResponseDto;
import com.ders.ornek.exceptions.StockNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksController {

    StocksService stocksService;

    @Autowired
    private StocksController(StocksService stocksService) {
        this.stocksService = stocksService;
    }

    @GetMapping("/findAllStocks")
    public ResponseEntity<List<StocksResponseDto>> findAllStocks() {
        List<StocksResponseDto> stocksResponseDtos = stocksService.findAllStocks();
        if (stocksResponseDtos.isEmpty()) {
            throw new StockNotFoundException("Hiç stok yok.");
        }
        return new ResponseEntity<>(stocksResponseDtos, HttpStatus.OK);
    }

    @PostMapping("/saveStock")
    public ResponseEntity<Long> saveStock(@RequestBody StocksRequestDto stocksRequestDto) {
        Long stocId = stocksService.saveStock(stocksRequestDto);
        return new ResponseEntity<>(stocId, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStock")
    public ResponseEntity<Boolean> deleteStock(@RequestParam Long stockId) {
        Boolean isDelete = stocksService.deleteStock(stockId);
        return new ResponseEntity<>(isDelete, HttpStatus.OK);
    }
}
