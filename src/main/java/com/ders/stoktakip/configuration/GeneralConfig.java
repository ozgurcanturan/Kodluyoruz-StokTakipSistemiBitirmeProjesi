package com.ders.stoktakip.configuration;

import com.ders.stoktakip.model.*;
import com.ders.stoktakip.model.enums.StockCategorys;
import com.ders.stoktakip.model.enums.Units;
import com.ders.stoktakip.dao.*;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GeneralConfig {
    @Autowired
    StocksRepository stocksRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ProductReturnRepository productReturnRepository;
    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;

    @PostConstruct
    public void initData() {
        initStock();
        initCorporateCustomerData();
        initIndividualCustomer();
        //initSales();
        initProductReturn();
    }


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
        corporateCustomer.setUserName("deneme1");
        corporateCustomer.setPassword("1234");
        corporateCustomer.setEmail("asd5@gmail.com");

        CorporateCustomer corporateCustomer1 = new CorporateCustomer();
        corporateCustomer1.setName("Arslan Market");
        corporateCustomer1.setTaxNumber(1234567891);
        corporateCustomer1.setAddress("Tunceli/Mazgirt");
        corporateCustomer1.setDiscount(1);
        corporateCustomer1.setUserName("deneme2");
        corporateCustomer1.setPassword("1234");
        corporateCustomer1.setEmail("asd4@gmail.com");

        customerRepository.saveAll(Arrays.asList(corporateCustomer, corporateCustomer1));

    }

    private void initIndividualCustomer() {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("Özgür Can");
        individualCustomer.setLastName("Turan");
        individualCustomer.setDiscount(0);
        individualCustomer.setNationalId("12345678901");
        individualCustomer.setUserName("deneme3");
        individualCustomer.setPassword("1234");
        individualCustomer.setEmail("asd@gmail.com");

        IndividualCustomer individualCustomer1 = new IndividualCustomer();
        individualCustomer1.setName("Özge Elif");
        individualCustomer1.setLastName("Arslan");
        individualCustomer1.setDiscount(0);
        individualCustomer1.setNationalId("12345678902");
        individualCustomer1.setUserName("deneme4");
        individualCustomer1.setPassword("1234");
        individualCustomer1.setEmail("asd1@gmail.com");
        customerRepository.saveAll(Arrays.asList(individualCustomer, individualCustomer1));
    }

    private void initSales() {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("Baki Emre");
        individualCustomer.setLastName("Dönmez");
        individualCustomer.setDiscount(0);
        individualCustomer.setNationalId("12345678903");
        individualCustomer.setEmail("asd2@gmail.com");
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
        sales.setSalesUnit(Units.KG);
        sales.setStock(stock);
        sales.setSalePrice(5);
        salesRepository.save(sales);
    }

    private void initProductReturn() {
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setName("Türkan");
        individualCustomer.setLastName("Balta");
        individualCustomer.setDiscount(0);
        individualCustomer.setNationalId("12345641903");
        individualCustomer.setUserName("deneme5");
        individualCustomer.setPassword("1234");
        individualCustomer.setEmail("asd3@gmail.com");
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
        sales.setSalesUnit(Units.KG);
        sales.setStock(stock);
        sales.setSalePrice(5);
        salesRepository.save(sales);

        ProductReturn productReturn = new ProductReturn();
        productReturn.setSalesId(sales);
        productReturn.setProductReturnAmount(0.5);
        productReturn.setProductReturnMessage("üründe çürük çıkmış");
        productReturn.setReturnUnits(Units.KG);
        productReturn.setCustomer(individualCustomer);
        productReturn.setStocks(stock);
        productReturnRepository.save(productReturn);
    }


}
