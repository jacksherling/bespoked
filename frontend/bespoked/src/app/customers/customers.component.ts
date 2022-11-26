import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Customer } from '../entities';
import { CONSTANTS, Response } from '../util';

@Injectable()
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers: Customer[] = [];
  newCustomer: Customer = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers() {
    this.http.get<Response>(CONSTANTS.apiURL + "/customer").subscribe((response: Response) => {
      this.customers = response.data;
    });
  }

  createNewCustomer() {
    this.http.post<Response>(CONSTANTS.apiURL + "/customer", this.newCustomer).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.getCustomers();
      }
    });
  }

}
