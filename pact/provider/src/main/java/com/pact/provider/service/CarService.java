package com.pact.provider.service;

import com.pact.provider.model.Car;
import com.pact.provider.repo.MemoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    MemoryRepo memoryRepo;

    public List<Car> getCars() {
        return memoryRepo.getCars();
    }
}
