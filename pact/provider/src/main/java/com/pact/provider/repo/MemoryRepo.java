package com.pact.provider.repo;

import com.pact.provider.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MemoryRepo {
    private List<Car> cars;

    public MemoryRepo() {
        this.cars = new ArrayList<>();
        addCar(new Car(UUID.randomUUID(), "Tesla", "S"));
        addCar(new Car(UUID.randomUUID(), "Ford", "Mustang"));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
