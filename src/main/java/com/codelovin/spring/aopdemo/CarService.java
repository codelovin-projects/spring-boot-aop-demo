package com.codelovin.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	private Logger logger = Logger.getLogger(CarService.class.getName());
	
	@Autowired
	private CarRepository carRepository;
	
	public void storeCar(Car car) {
		logger.info("CarService.storeCar(Car) starts...");
		if (car.getId() <= 0) {
			throw new IllegalArgumentException("Please provide positive ID number");
		}
		carRepository.insertCar(car);
		logger.info("CarService.storeCar(Car) finishes...");
	}
}
