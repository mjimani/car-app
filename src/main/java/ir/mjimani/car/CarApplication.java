package ir.mjimani.car;

import ir.mjimani.car.domain.ElectricalCar;
import ir.mjimani.car.domain.SportCar;
import ir.mjimani.car.domain.TwoWheelsCar;
import ir.mjimani.car.domain.enums.CarType;
import ir.mjimani.car.domain.enums.FuelType;
import ir.mjimani.car.domain.enums.GearBoxType;
import ir.mjimani.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"ir.mjimani.car.repository",
		"ir.mjimani.car.service",
		"ir.mjimani.car.controller",
})
public class CarApplication implements CommandLineRunner {

	@Autowired
	private CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Override
	public void run(String... args) {
		SportCar sportCar = new SportCar();
		sportCar.setName("Porsche 718");
		sportCar.setCarType(CarType.SPORT);
		sportCar.setGasolineCapacity("60L");
		sportCar.setGearBoxType(GearBoxType.MANUAL);
		sportCar.setMaxSpeed("220KM/H");
		carService.insert(sportCar);

		ElectricalCar electricalCar = new ElectricalCar();
		electricalCar.setName("Tesla s");
		electricalCar.setCarType(CarType.ELECTRICAL);
		electricalCar.setBatteryCapacity("15H");
		electricalCar.setGearBoxType(GearBoxType.MANUAL);
		electricalCar.setMaxSpeed("250KM/H");
		carService.insert(electricalCar);

		TwoWheelsCar twoWheelsCar = new TwoWheelsCar();
		twoWheelsCar.setName("Bloomberg");
		twoWheelsCar.setCarType(CarType.TWO_WHEELS);
		twoWheelsCar.setFuelType(FuelType.GASOLINE);
		twoWheelsCar.setFuelCapacity("15L");
		twoWheelsCar.setGearBoxType(GearBoxType.MANUAL);
		twoWheelsCar.setMaxSpeed("250KM/H");
		carService.insert(twoWheelsCar);
	}
}
