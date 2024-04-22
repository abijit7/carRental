package com.carRentalSystem.ServiceIMPL;

import com.carRentalSystem.Entity.Vendor;
import com.carRentalSystem.Exception.ResourceNotFound;
import com.carRentalSystem.Mapper.VendorMapper;
import com.carRentalSystem.Model.VendorModel;
import com.carRentalSystem.Repository.VendorLoginRepo;
import com.carRentalSystem.Repository.VendorRepo;
import com.carRentalSystem.Service.VendorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendorServiceIMPL implements VendorService {
   private final VendorRepo vendorRepo;
   private final VendorMapper vendorMapper;
   private final VendorLoginRepo vendorLoginRepo;
   private final ModelMapper modelMapper;
    @Override
    public List<VendorModel> getAllVendor() {
        return vendorRepo.findAll().stream().map(
                vendorMapper::convertVendorToVendorDTO).collect(Collectors.toList());
    }

    @Override
    public VendorModel getByVendorId(Long vendorId) {
        Vendor vendor  = this.vendorRepo.findById(vendorId).orElseThrow(()->new ResourceNotFound("Vendor not found"));
        return this.vendorMapper.convertVendorToVendorDTO(vendor);
    }

    @Override
    public VendorModel addVendor(VendorModel vendorModel) {
         {
            Vendor vendor = this.vendorMapper.convertVendorDTOToVendor(vendorModel);
            Vendor savedVendor = this.vendorRepo.save(vendor);
            return this.vendorMapper.convertVendorToVendorDTO(savedVendor);
        }
    }

    @Override
    public VendorModel updateVendor(VendorModel vendorModel, Long vendorId) {
        Vendor vendor = this.vendorRepo.findById(vendorId).orElseThrow(()->
                new ResourceNotFound("Vendor not found"));
        vendor.setEmail(vendorModel.getEmail());
        vendor.setFirstName(vendorModel.getFirstName());
        vendor.setLastName(vendorModel.getLastName());
        vendor.setPassword(vendorModel.getPassword());
        vendor.setLicenseNumber(vendorModel.getLicenseNumber());
        vendor.setMobileNumber(vendorModel.getMobileNumber());
        vendor.setRegistrationNo(String.valueOf(vendorModel.getRegistrationNo()));
        vendor.setStatus(vendorModel.getStatus());
        Vendor saved = this.vendorRepo.save(vendor);
        return this.vendorMapper.convertVendorToVendorDTO(saved);

    }

    @Override
    public void deleteVendor(Long vendorId) {
Vendor vendor  = this.vendorRepo.findById(vendorId).orElseThrow(()->new ResourceNotFound("vendor not found"));
    this.vendorRepo.delete(vendor);
    }


}
