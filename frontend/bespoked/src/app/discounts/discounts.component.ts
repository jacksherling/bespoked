import { Component, OnInit } from '@angular/core';
import { Discount, Product } from '../entities';
import { HttpClient } from '@angular/common/http';
import { CONSTANTS, Response } from '../util';

@Component({
  selector: 'app-discounts',
  templateUrl: './discounts.component.html',
  styleUrls: ['./discounts.component.css']
})
export class DiscountsComponent implements OnInit {

  discounts: Discount[] = [];
  newDiscount: Discount = { product: {} };

  products: Product[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getDiscounts();
    this.http.get<Response>(CONSTANTS.apiURL + "/product").subscribe((response: Response) => {
      this.products = response.data;
    });
  }

  getDiscounts() {
    this.http.get<Response>(CONSTANTS.apiURL + "/discount").subscribe((response: Response) => {
      this.discounts = response.data;
    });
  }

  createNewDiscount() {
    this.http.post<Response>(CONSTANTS.apiURL + "/discount", this.newDiscount).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.getDiscounts();
      }
    });
  }

}
