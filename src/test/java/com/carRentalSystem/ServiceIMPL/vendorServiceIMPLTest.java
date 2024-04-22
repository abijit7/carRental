package com.carRentalSystem.ServiceIMPL;

import com.carRentalSystem.Entity.Vendor;
import com.carRentalSystem.Mapper.VendorMapper;
import com.carRentalSystem.Model.VendorModel;
import com.carRentalSystem.Repository.VendorRepo;
import com.carRentalSystem.Service.VendorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class vendorServiceIMPLTest {
@InjectMocks
VendorServiceIMPL vendorService;
@Mock
VendorRepo vendorRepo;
@Mock
VendorMapper vendorMapper;
public void  init(){
    MockitoAnnotations.openMocks(this);
}
    @Test
    void getAllVendor() {
        List<Vendor> vendorModels = new ArrayList<>();
        Vendor vendor = new Vendor(1L,
                "vendor-login"
                ,"abijit","pariyar"
                ,"abijit@gmail.com"
                ,"9818100273"
                ,"9818100273"
                ,"RDS1234567"
                ,"124567ERT"
                ,"A");
        vendorModels.add(vendor);
        //mock
        when(vendorRepo.findAll()).thenReturn(vendorModels);
        when(vendorMapper.convertVendorToVendorDTO(any(Vendor.class))).thenReturn(new VendorModel(
                1L,
                "vendor-login"
                ,"abijit","pariyar"
                ,"abijit@gmail.com"
                ,"9818100273"
                ,"9818100273"
                ,"RDS1234567"
                ,"124567ERT"
                ,"A")
        );
        List<VendorModel> getVendor = vendorService.getAllVendor();

        assertEquals(vendorModels.size(),getVendor.size());
    }

    @Test
    void getByVendorId() {
Vendor vendor = new Vendor( 1L,
        "vendor-login"
        ,"abijit","pariyar"
        ,"abijit@gmail.com"
        ,"9818100273"
        ,"9818100273"
        ,"RDS1234567"
        ,"124567ERT"
        ,"A");
//when
        when(vendorRepo.findById(vendor.getId())).thenReturn(Optional.of(vendor));
        when(vendorMapper.convertVendorToVendorDTO(any(Vendor.class))).thenReturn(new VendorModel(
                1,
                "vendor-login"
                ,"abijit","pariyar"
                ,"abijit@gmail.com"
                ,"9818100273"
                ,"9818100273"
                ,"RDS1234567"
                ,"124567ERT"
                ,"A"
        ));
    VendorModel vendorModels = vendorService.getByVendorId(vendor.getId());
    assertEquals(vendor.getId(),vendorModels.getId());
    }

    @Test
    void addVendor() {
    }

    @Test
    void updateVendor() {
    }

    @Test
    void deleteVendor() {
    }

    @Test
    void saveVendorLogin() {
    }
}