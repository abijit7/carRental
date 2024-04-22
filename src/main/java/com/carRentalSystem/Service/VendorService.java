package com.carRentalSystem.Service;

import com.carRentalSystem.Model.VendorModel;

import java.util.List;

public interface VendorService {
     List<VendorModel> getAllVendor();
     VendorModel getByVendorId(Long vendorId);
     VendorModel addVendor(VendorModel vendorModel);
     VendorModel updateVendor(VendorModel vendorModel,Long vendorId);
     void deleteVendor(Long vendorId);

}
