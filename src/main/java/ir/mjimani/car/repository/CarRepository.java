package ir.mjimani.car.repository;

import ir.mjimani.car.domain.Car;
import ir.mjimani.car.domain.enums.CarType;
import org.springframework.stereotype.Repository;

public interface CarRepository {

    Boolean insert(Car car);

    Car findByCarType(CarType carType);
}
