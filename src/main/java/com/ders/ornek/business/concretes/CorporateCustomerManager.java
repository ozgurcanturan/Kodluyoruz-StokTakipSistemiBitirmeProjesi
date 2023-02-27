package com.ders.ornek.business.concretes;

import com.ders.ornek.business.abstracts.CorporateCustomerService;
import com.ders.ornek.dto.requestDtos.CorporateCustomerRequestDto;
import com.ders.ornek.dto.responseDtos.CorporateCustomerResponseDto;
import com.ders.ornek.model.CorporateCustomer;
import com.ders.ornek.exceptions.CustomerNotFoundException;
import com.ders.ornek.dao.CorporateCustomerRepository;
import com.ders.ornek.dao.ProductReturnRepository;
import com.ders.ornek.dao.SalesRepository;
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
