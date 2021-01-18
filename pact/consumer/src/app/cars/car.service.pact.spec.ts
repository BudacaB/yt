import { TestBed, async } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { CarService } from './car.service';
import { Car } from './car';
import * as path from 'path';
import { Matchers, Pact } from '@pact-foundation/pact';

describe('CarServicePact', () => {
  const provider: Pact = new Pact({
    port: 1234,
    log: path.resolve(process.cwd(), 'pact', 'logs', 'mockserver-integration.log'),
    dir: path.resolve(process.cwd(), 'pacts'),
    spec: 3,
    logLevel: 'info',
    consumer: 'car-consumer',
    provider: 'carservice'
  });

    // Setup Pact mock server for this service
    beforeAll(async () => {
      await provider.setup();
    });


  // Configure Angular Testbed for this service
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        HttpClientModule
      ],
      providers: [
        CarService
      ]
    });
  });

  // Verify mock service
  afterEach(async () => {
    await provider.verify();
  });

  // Create contract
  afterAll(async () => {
    await provider.finalize();
  });

  describe('getCars', () => {
    const expectedCars: Car[] = [
      {
        id: "1",
        make: 'Tesla',
        model: 'S'
      },
      {
        id: "2",
        make: 'BMW',
        model: '3Series'
      }
    ];

    beforeAll(async () => {
      await provider.addInteraction({
        state: 'cars exist',
        uponReceiving: 'a request to GET cars',
        withRequest: {
          method: 'GET',
          path: '/cars'
        },
        willRespondWith: {
          status: 200,
          body: Matchers.somethingLike(expectedCars)
        }
      });
    });

    it('should get cars', async () => {
      const carService: CarService = TestBed.inject(CarService);

      await carService.getCars().toPromise().then(response => {
        expect(response).toEqual(expectedCars);
      });
    });

  })

})

