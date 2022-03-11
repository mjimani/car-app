package ir.mjimani.car.repository;

import ir.mjimani.car.domain.Car;
import ir.mjimani.car.domain.enums.CarType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepositoryImp implements CarRepository {

    private static Map<CarType, Car> carData = new HashMap<>();

    @Override
    public Boolean insert(Car car) {
        carData.put(car.getCarType(), car);
        return true;
    }

    @Override
    public Car findByCarType(CarType carType) {
        return carData.get(carType);
    }
}
