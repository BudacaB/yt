package com.demo.tdd

import org.springframework.stereotype.Service

@Service
class CarService (val carRepo: CarRepo) {
    fun addCar(car: Car): Car = carRepo.save(car)
}
