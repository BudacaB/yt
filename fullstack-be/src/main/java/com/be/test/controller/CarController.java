package com.be.test.controller;

import com.be.test.model.Car;
import com.be.test.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping(path = "/cars")
    public ResponseEntity<List<Car>> retrieveCars() {
        try {
            List<Car> cars = new ArrayList<>();
            carRepository.findAll().forEach(cars::add);

            if (cars.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/car")
    public ResponseEntity<Car> saveCar (@RequestBody Car car) {
        try {
            Car _car = carRepository.save(new Car(UUID.randomUUID(), car.getMake(), car.getModel()));
            return new ResponseEntity<>(_car, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
