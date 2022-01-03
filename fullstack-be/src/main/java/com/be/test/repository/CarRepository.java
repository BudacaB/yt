package com.be.test.repository;

import com.be.test.model.Car;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface CarRepository extends CassandraRepository<Car, UUID> { }
