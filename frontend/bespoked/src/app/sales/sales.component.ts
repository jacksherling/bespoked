import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Customer, Salesperson, Sale, Product } from '../entities';
import { CONSTANTS, Response } from '../util';

@Injectable()
@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {

  sales: Sale[] = [];
  newSale: Sale = { customer: {}, salesperson: {}, product: {}};

  products: Product[] = [];
  salespeople: Salesperson[] = [];
  customers: Customer[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getSales();
    this.http.get<Response>(CONSTANTS.apiURL + "/salesperson").subscribe((response: Response) => {
      this.salespeople = response.data;
    });
    this.http.get<Response>(CONSTANTS.apiURL + "/product").subscribe((response: Response) => {
      this.products = response.data;
    });
    this.http.get<Response>(CONSTANTS.apiURL + "/customer").subscribe((response: Response) => {
      this.customers = response.data;
    });
  }

  getSales() {
    this.http.get<Response>(CONSTANTS.apiURL + "/sale").subscribe((response: Response) => {
      this.sales = response.data;
    });
  }

  createNewSale() {
    console.log(this.newSale)
    this.newSale.product!.purchasePrice = this.products.find(p => p.id == this.newSale.product?.id)?.purchasePrice;
    this.http.post<Response>(CONSTANTS.apiURL + "/sale", this.newSale).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.getSales();
      }
    });
  }

}
