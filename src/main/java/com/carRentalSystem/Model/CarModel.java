package com.carRentalSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

    private Long id;
    private String carType;
    private String carModel;
    private String carSeater;
    private String bagageCapacity;
    private String carRegistration;
    private String AcOrNonAc;
    private String basePrice;
    private Long minKmDriven;
    private String yearsOld;
    private String insurance;
    private String status;
    private String imageUrl;
    private Long vendorId;

}
