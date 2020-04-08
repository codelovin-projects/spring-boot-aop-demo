package com.codelovin.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

	private Logger logger = Logger.getLogger(CarService.class.getName());
	
	public void insertCar(Car car) {
		logger.info("CarRepository.insertCar(Car) starts...");
		//Do nothing
		logger.info("CarRepository.insertCar(Car) starts...");
	}
}
