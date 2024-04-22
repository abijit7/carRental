package com.carRentalSystem.Service;
import com.carRentalSystem.Model.CarModel;
import java.util.List;

public interface CarService {

     CarModel addCar(Long vendorId,CarModel carModel);
   List <CarModel> getAllCar();
    CarModel updateCar(CarModel carModel,Long carId);
    void deleteCar(Long carId);
}
