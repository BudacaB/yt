package com.pact.provider;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import com.pact.provider.model.Car;
import com.pact.provider.service.CarService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Provider("carservice")
//@PactFolder("pacts")
@PactBroker(host = "localhost", port = "9292")
public class CarServiceVerificationTest {

    private CarService carService = mock(CarService.class);

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @BeforeAll
    static void start() {
        ConfigurableWebApplicationContext application = (ConfigurableWebApplicationContext)
                SpringApplication.run(ProviderApplication.class);
    }

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", 8080));
    }

    @State({"cars exist"})
    void carsExist() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(UUID.randomUUID(), "Tesla", "S"));
        cars.add(new Car(UUID.randomUUID(), "Ford", "Mustang"));
        when(carService.getCars()).thenReturn(cars);
    }

    @State({"searched cars exist"})
    void searchedCarsExist() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(UUID.randomUUID(), "Tesla", "S"));
        when(carService.getCar("tesla")).thenReturn(cars);
    }


}
