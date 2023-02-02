package com.ders.ornek.configuration;

import com.ders.ornek.entity.CorporateCustomer;
import com.ders.ornek.entity.IndividualCustomer;
import com.ders.ornek.entity.Sales;
import com.ders.ornek.entity.Stocks;
import com.ders.ornek.entity.enums.StockCategorys;
import com.ders.ornek.entity.enums.Units;
import com.ders.ornek.repository.CustomerRepository;
import com.ders.ornek.repository.SalesRepository;
import com.ders.ornek.repository.StocksRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class GeneralConfig {
    @Autowired
    StocksRepository stocksRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SalesRepository salesRepository;

//    @PostConstruct
//    public void initData() {
//        initStock();
//        initCorporateCustomerData();
//        initIndividualCustomer();
//        initSales();
//    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private void initStock() {
        Stocks stock = new Stocks();
        stock.setStockAmount(10);
        stock.setBarcode("123456789012345");
        stock.setStockName("Banana");
        stock.setStockCategory(StockCategorys.BUTCHER);
        stock.setUnits(Units.KG);
        stock.setUnitPrice(40);

        Stocks stock1 = new Stocks();
        stock1.setStockAmount(20);
        stock1.setBarcode("123456789012346");
        stock1.setStockName("Cherry");
        stock1.setStockCategory(StockCategorys.BUTCHER);
        stock1.setUnits(Units.KG);
        stock1.setUnitPrice(20);

        Stocks stock2 = new Stocks();
        stock2.setStockAmount(100);
        stock2.setBarcode("123456789012347");
        stock2.setStockName("Water");
        stock2.setStockCategory(StockCategorys.FOOD);
        stock2.setUnits(Units.PCS);
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

    private void initSales() {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("Baki Emre");
        individualCustomer.setLastName("Dönmez");
        individualCustomer.setDiscount(0);
        individualCustomer.setNationalId("12345678903");
        customerRepository.save(individualCustomer);

        Stocks stock = new Stocks();
        stock.setStockAmount(10);
        stock.setBarcode("123456789012349");
        stock.setStockName("Mulberry");
        stock.setStockCategory(StockCategorys.BUTCHER);
        stock.setUnits(Units.KG);
        stock.setUnitPrice(40);
        stocksRepository.save(stock);

        Sales sales = new Sales();
        sales.setCustomer(individualCustomer);
        sales.setSalesAmount(1);
        sales.setSalesDate(LocalDate.now());
        sales.setSalesUnit(Units.KG);
        sales.setStock(stock);
        sales.setSalePrice(5);
        salesRepository.save(sales);
    }


}
