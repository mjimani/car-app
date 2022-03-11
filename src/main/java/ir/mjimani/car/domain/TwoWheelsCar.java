package ir.mjimani.car.domain;

import ir.mjimani.car.domain.enums.FuelType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TwoWheelsCar extends Car{
    private FuelType fuelType;
    private String fuelCapacity;
}
