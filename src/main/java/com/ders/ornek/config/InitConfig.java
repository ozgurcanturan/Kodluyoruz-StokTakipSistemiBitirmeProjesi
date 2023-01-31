package com.ders.ornek.config;

import com.ders.ornek.entity.CorporateCustomer;
import com.ders.ornek.entity.IndividualCustomer;
import com.ders.ornek.entity.Stocks;
import com.ders.ornek.entity.enums.StockCategorys;
import com.ders.ornek.entity.enums.StockUnits;
import com.ders.ornek.repository.CustomerRepository;
import com.ders.ornek.repository.StocksRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InitConfig {
    @Autowired
    StocksRepository stocksRepository;
    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void initData() {
        initStock();
        initCorporateCustomerData();
        initIndividualCustomer();
    }

    private void initStock() {
        Stocks stock = new Stocks();
        stock.setStockAmount(10);
        stock.setStockName("Banana");
        stock.setStockCategory(StockCategorys.BUTCHER);
        stock.setStockUnits(StockUnits.KG);
        stock.setUnitPrice(40);

        Stocks stock1 = new Stocks();
        stock1.setStockAmount(20);
        stock1.setStockName("Cherry");
        stock1.setStockCategory(StockCategorys.BUTCHER);
        stock1.setStockUnits(StockUnits.KG);
        stock1.setUnitPrice(20);

        Stocks stock2 = new Stocks();
        stock2.setStockAmount(100);
        stock2.setStockName("Water");
        stock2.setStockCategory(StockCategorys.FOOD);
        stock2.setStockUnits(StockUnits.PCS);
        stock2.setUnitPrice(5);


        stocksRepository.saveAll(Arrays.asList(stock, stock1, stock2));
    }

    private void initCorporateCustomerData() {
        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setName("Dersim Manav");
        corporateCustomer.setTaxNumber(1234567890);
        corporateCustomer.setAddress("Tunceli/Merkez");
        corporateCustomer.setDiscount(0);

        CorporateCustomer corporateCustomer1 = new CorporateCustomer();
        corporateCustomer1.setName("Arslan Market");
        corporateCustomer1.setTaxNumber(1234567891);
        corporateCustomer1.setAddress("Tunceli/Mazgirt");
        corporateCustomer1.setDiscount(1);

        customerRepository.saveAll(Arrays.asList(corporateCustomer, corporateCustomer1));

    }

    private void initIndividualCustomer() {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("Özgür Can");
        individualCustomer.setLastName("Turan");
        individualCustomer.setDiscount(0);
        individualCustomer.setNationalId("12345678901");

        IndividualCustomer individualCustomer1 = new IndividualCustomer();
        individualCustomer1.setName("Özge Elif");
        individualCustomer1.setLastName("Arslan");
        individualCustomer1.setDiscount(0);
        individualCustomer1.setNationalId("12345678902");
        customerRepository.saveAll(Arrays.asList(individualCustomer, individualCustomer1));
    }
}
