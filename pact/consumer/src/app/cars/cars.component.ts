import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[];
  searchedCars: Car[];
  make: String;

  constructor(private carService: CarService) { }

  ngOnInit(): void {
    this.getCars();
  }

  getCars() {
    return this.carService.getCars().subscribe(result => this.cars = result);
  }

  getCar() {
   return this.carService.getCar(this.make.toLowerCase()).subscribe(result => this.searchedCars = result);
  }
}
