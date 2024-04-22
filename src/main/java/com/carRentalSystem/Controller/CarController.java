package com.carRentalSystem.Controller;

import com.carRentalSystem.Model.CarModel;
import com.carRentalSystem.Service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<CarModel>> getAllCar() {
        List<CarModel> carModel = this.carService.getAllCar();
        return new ResponseEntity<>(carModel, HttpStatus.OK);
    }

    @PostMapping("/add/vendor-id/{id}")
    public ResponseEntity<CarModel> addCar(@RequestBody CarModel carModel, @PathVariable("id") Long vendorId) {
        CarModel addCar = this.carService.addCar(vendorId,carModel);
        return new ResponseEntity<>(addCar,HttpStatus.CREATED);
    }
    @PutMapping("/update/car-id/{id}")
    public ResponseEntity<CarModel> updateCar(@RequestBody CarModel carModel,@PathVariable("id") Long carId){
        CarModel updateCar = this.carService.updateCar(carModel,carId);
        return new ResponseEntity<>(updateCar,HttpStatus.OK);
    }
    @DeleteMapping("/delete/car-id/{carId}")
    public void  deleteCar(@PathVariable("id") Long carId ){
        this.carService.deleteCar(carId);
    }
}