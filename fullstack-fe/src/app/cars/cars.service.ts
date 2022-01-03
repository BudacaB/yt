import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Car } from './car';

@Injectable({
  providedIn: 'root'
})
export class CarsService {

  constructor(private http: HttpClient) { }

  retrieveCars(){
    return this.http.get<Car[]>('http://localhost:8080/cars/');
  }

  saveCar(car: Car) {
    return this.http.post<Car>('http://localhost:8080/car/', car);
  }
}
