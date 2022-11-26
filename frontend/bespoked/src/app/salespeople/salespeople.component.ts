import { Component, OnInit } from '@angular/core';
import { Salesperson } from '../entities';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CONSTANTS, Response } from '../util';


@Injectable()
@Component({
  selector: 'app-salespeople',
  templateUrl: './salespeople.component.html',
  styleUrls: ['./salespeople.component.css']
})
export class SalespeopleComponent implements OnInit {

  salespeople: Salesperson[] = [];
  newSalesperson: Salesperson = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getSalespeople();
  }

  getSalespeople() {
    this.http.get<Response>(CONSTANTS.apiURL + "/salesperson").subscribe((response: Response) => {
      this.salespeople = response.data;
    });
  }

  createNewSalesperson() {
    this.http.post<Response>(CONSTANTS.apiURL + "/salesperson", this.newSalesperson).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.getSalespeople();
      } else {
        alert(response.message);
      }
    });
  }

}
