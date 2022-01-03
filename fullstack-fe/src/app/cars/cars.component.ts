import { Component, OnInit } from '@angular/core';
import { CarsService } from './cars.service';
import { Car } from './car';

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Car[];
  car: Car;

  constructor(private carService: CarsService) { }

  ngOnInit(){
    this.retrieveCars();
    this.car = new Car('', '', '');
  }

  retrieveCars() {
    return this.carService.retrieveCars().subscribe(result => this.cars = result);
  }

  saveCar(){
    return this.carService.saveCar(this.car).subscribe(data => console.log(data));
  }

}
