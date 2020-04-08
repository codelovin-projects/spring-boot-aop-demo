package com.codelovin.spring.aopdemo;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping("/api/cars")
	public ResponseEntity<Map<String, String>> saveCar(@Valid @RequestBody Car car) {
		carService.storeCar(car);
		Map<String, String> m = new HashMap<>();
		m.put("status", "SUCCESS");
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
}
