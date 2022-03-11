package ir.mjimani.car.domain;

import ir.mjimani.car.domain.enums.CarType;
import ir.mjimani.car.domain.enums.GearBoxType;
import lombok.*;

@Setter
@Getter
public class Car {
    protected Integer id;
    protected String name;
    protected CarType carType;
    protected GearBoxType gearBoxType;
    protected String maxSpeed;
}
