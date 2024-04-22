package com.carRentalSystem.ServiceIMPL;

import com.carRentalSystem.Entity.Car;
import com.carRentalSystem.Entity.Vendor;
import com.carRentalSystem.Exception.ResourceNotFound;
import com.carRentalSystem.Model.CarModel;
import com.carRentalSystem.Repository.CarRepo;
import com.carRentalSystem.Repository.VendorRepo;
import com.carRentalSystem.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CarServiceImpl implements CarService {
    private final VendorRepo vendorRepo;
    private final CarRepo carRepo;
    private final ModelMapper modelMapper;
    @Override
    public CarModel addCar(Long vendorId, CarModel carModel) {
        Vendor vendor = this.vendorRepo.findById(vendorId).orElseThrow(()->new ResourceNotFound("Vendor not found "));
        Car car = this.modelMapper.map(carModel, Car.class);
        Car saved = this.carRepo.save(car);
        return this.modelMapper.map(saved, CarModel.class);
    }

    @Override
    public List<CarModel> getAllCar() {
        return this.carRepo.findAll().stream().map((cars)->this.modelMapper.map(cars, CarModel.class)).collect(Collectors.toList());
    }

    @Override
    public CarModel updateCar(CarModel carModel, Long carId) {
        Car car = this.carRepo.findById(carId).orElseThrow(()->new ResourceNotFound("Car not found"));
        car.setCarType(carModel.getCarType());
        car.setCarModel(carModel.getCarModel());
        car.setCarSeater(carModel.getCarSeater());
        car.setAcOrNonAc(carModel.getAcOrNonAc());
        car.setBasePrice(carModel.getBasePrice());
        car.setMinKmDriven(carModel.getMinKmDriven());
        car.setYearsOld(carModel.getYearsOld());
        car.setInsurance(carModel.getInsurance());
        car.setStatus(carModel.getStatus());
        car.setImageUrl(carModel.getImageUrl());
        return this.modelMapper.map(car, CarModel.class);
    }

    @Override
    public void deleteCar(Long carId) {
 Car car = this.carRepo.findById(carId).orElseThrow(()->new ResourceNotFound("car not found"));
 this.carRepo.delete(car);
    }
}
