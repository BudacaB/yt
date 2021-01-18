package com.pact.provider.controller;

import com.pact.provider.model.Car;
import com.pact.provider.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @CrossOrigin(value = "*")
    @GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Car>> getCars() {
        List<Car> cars = new ArrayList<>();
        try {
            cars = carService.getCars();
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(cars, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(value = "*")
    @GetMapping(value = "/car/{make}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Car>> getCar(@PathVariable String make) {
        List<Car> cars = new ArrayList<>();
        try {
            cars = carService.getCar(make);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(cars, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
