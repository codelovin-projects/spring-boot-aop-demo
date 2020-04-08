package com.codelovin.spring.aopdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	private Logger logger = Logger.getLogger(CarController.class.getName());
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/api/cars")
	public ResponseEntity<Map<String, String>> saveCar(@Valid @RequestBody Car car) {
		logger.info("CarController.saveCar(Car) starts...");
		carService.storeCar(car);
		Map<String, String> m = new HashMap<>();
		m.put("status", "SUCCESS");
		logger.info("CarController.saveCar(Car) finishes...");
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
}
