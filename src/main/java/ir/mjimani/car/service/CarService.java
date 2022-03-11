package ir.mjimani.car.service;

import ir.mjimani.car.domain.Car;
import ir.mjimani.car.domain.enums.CarType;
import ir.mjimani.car.exception.APIException;
import ir.mjimani.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void insert(Car car) {
        carRepository.insert(car);
    }

    public Car findByCarType(CarType carType) {
        if (carType == null){
            throw new APIException("Car type is missing!");
        }
        return carRepository.findByCarType(carType);
    }
}
