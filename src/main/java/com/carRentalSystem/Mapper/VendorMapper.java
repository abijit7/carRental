package com.carRentalSystem.Mapper;

import com.carRentalSystem.Entity.Vendor;
import com.carRentalSystem.Model.VendorModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
public class VendorMapper {
    private final ModelMapper modelMapper;

    public VendorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VendorModel convertVendorToVendorDTO(Vendor vendor){
        VendorModel vendorModel = new VendorModel();
        vendorModel = this.modelMapper.map(vendor, VendorModel.class);
        return vendorModel;
    }
    public Vendor convertVendorDTOToVendor(VendorModel vendorModel){
        Vendor vendor = new Vendor();
        vendor  = this.modelMapper.map(vendorModel, Vendor.class);
        return vendor;
    }
}
