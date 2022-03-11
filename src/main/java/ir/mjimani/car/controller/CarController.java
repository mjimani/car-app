package ir.mjimani.car.controller;

import ir.mjimani.car.domain.Car;
import ir.mjimani.car.domain.enums.CarType;
import ir.mjimani.car.exception.APIException;
import ir.mjimani.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/get-by-type")
    public ResponseEntity<Car> findOneByCarType(@RequestParam("carType") CarType carType) {
        return ResponseEntity.ok().body(carService.findByCarType(carType));
    }
}
