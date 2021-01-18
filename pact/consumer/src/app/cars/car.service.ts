import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Car } from './car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getCars(){
    return this.http.get<Car[]>(`${this.BASE_URL}/cars`);
  }

  getCar(make: String) {
    return this.http.get<Car[]>(`${this.BASE_URL}/car/${make}`);
  }
}
