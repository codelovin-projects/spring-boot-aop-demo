package com.codelovin.spring.aopdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public void storeCar(Car car) {
		carRepository.insertCar(car);
	}
}
