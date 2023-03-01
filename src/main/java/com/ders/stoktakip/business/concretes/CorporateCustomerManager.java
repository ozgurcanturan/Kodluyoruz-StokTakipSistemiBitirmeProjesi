package com.ders.stoktakip.business.concretes;

import com.ders.stoktakip.business.abstracts.CorporateCustomerService;
import com.ders.stoktakip.dto.requestDtos.CorporateCustomerRequestDto;
import com.ders.stoktakip.dto.responseDtos.CorporateCustomerResponseDto;
import com.ders.stoktakip.model.CorporateCustomer;
import com.ders.stoktakip.exceptions.CustomerNotFoundException;
import com.ders.stoktakip.dao.CorporateCustomerRepository;
import com.ders.stoktakip.dao.ProductReturnRepository;
import com.ders.stoktakip.dao.SalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductReturnRepository productReturnRepository;


    @Override
    public Long saveCorporateCustomer(CorporateCustomerRequestDto corporateCustomerRequestDto) {
        CorporateCustomer corporateCustomer = modelMapper.map(corporateCustomerRequestDto, CorporateCustomer.class);
        corporateCustomer = corporateCustomerRepository.save(corporateCustomer);
        return corporateCustomer.getId();
    }

    @Override
    public List<CorporateCustomerResponseDto> findAllCorporateCustomers() {
        Iterable<CorporateCustomer> corporateCustomerList = corporateCustomerRepository.findAll();
        List<CorporateCustomerResponseDto> corporateCustomerResponseDtos = new ArrayList<>();
        for (CorporateCustomer corporateCustomer : corporateCustomerList) {
            CorporateCustomerResponseDto corporateCustomerResponseDto = modelMapper.map(corporateCustomer, CorporateCustomerResponseDto.class);
            corporateCustomerResponseDtos.add(corporateCustomerResponseDto);
        }
        return corporateCustomerResponseDtos;
    }


    @Override
    public boolean deleteCorporateCustomerById(Long corporateCustomerId) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(corporateCustomerId).orElseThrow(() -> new CustomerNotFoundException("Hata yakalandı, ID " + corporateCustomerId + " bulunamadı."));
        corporateCustomerRepository.deleteById(corporateCustomerId);
        return true;
    }
}
