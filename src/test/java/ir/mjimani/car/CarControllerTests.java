package ir.mjimani.car;

import ir.mjimani.car.controller.CarController;
import ir.mjimani.car.domain.Car;
import ir.mjimani.car.domain.enums.CarType;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

class CarControllerTests extends CarApplicationTests {

    @Autowired
    private CarController carController;

    @Test
    void find_sport_car() {
        ResponseEntity<Car> carResponseEntity = carController.findOneByCarType(CarType.SPORT);
        Assertions.assertEquals(200, carResponseEntity.getStatusCode().value());
        Assertions.assertNotNull(carResponseEntity.getBody());
        Car car = carResponseEntity.getBody();
        Assertions.assertEquals(CarType.SPORT, car.getCarType());
    }

    @Test
    void find_electrical_car() {
        ResponseEntity<Car> carResponseEntity = carController.findOneByCarType(CarType.ELECTRICAL);
        Assertions.assertEquals(200, carResponseEntity.getStatusCode().value());
        Assertions.assertNotNull(carResponseEntity.getBody());
        Car car = carResponseEntity.getBody();
        Assertions.assertEquals(CarType.ELECTRICAL, car.getCarType());
    }

    @Test
    void find_two_wheels_car() {
        ResponseEntity<Car> carResponseEntity = carController.findOneByCarType(CarType.TWO_WHEELS);
        Assertions.assertEquals(200, carResponseEntity.getStatusCode().value());
        Assertions.assertNotNull(carResponseEntity.getBody());
        Car car = carResponseEntity.getBody();
        Assertions.assertEquals(CarType.TWO_WHEELS, car.getCarType());
    }
}
