package com.carRentalSystem.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car-table")
public class Car {
    @Id
    @GeneratedValue(generator = "car-sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car-sequence",sequenceName = "car-sequence")
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
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonBackReference
    private Vendor vendor;
}
