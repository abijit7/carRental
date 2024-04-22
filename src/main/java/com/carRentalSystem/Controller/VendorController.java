package com.carRentalSystem.Controller;

import com.carRentalSystem.Model.VendorModel;
import com.carRentalSystem.Payload.VendorLoginModel;
import com.carRentalSystem.Service.VendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vendor")
public class VendorController {
    private final VendorService vendorService;
    @PostMapping("/add")
   public ResponseEntity<VendorModel> addVendor(@Valid @RequestBody VendorModel vendorModel){
    VendorModel addVendor = this.vendorService.addVendor(vendorModel);
    return new ResponseEntity<>(addVendor, HttpStatus.OK);
}
   @GetMapping("/all")
   public ResponseEntity<List<VendorModel>> getAllVendor(){
        List<VendorModel> getVendor = this.vendorService.getAllVendor();
        return new ResponseEntity<>(getVendor,HttpStatus.OK);
    }
    @DeleteMapping("delete/id/{id}")
    public void deleteVendor(@PathVariable("id") Long vendorId){
        this.vendorService.deleteVendor(vendorId);
    }
    @PutMapping("update/id/{id}")
    public ResponseEntity<VendorModel> update(@PathVariable("id") Long vendorId, @RequestBody VendorModel vendorModel){
      VendorModel update = this.vendorService.updateVendor(vendorModel,vendorId);
      return new ResponseEntity<>(update,HttpStatus.OK);
    }
}
