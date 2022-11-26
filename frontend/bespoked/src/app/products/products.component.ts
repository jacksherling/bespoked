import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from '../entities';
import { CONSTANTS, Response } from '../util';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products: Product[] = [];
  newProduct: Product = {};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts() {
    this.http.get<Response>(CONSTANTS.apiURL + "/product").subscribe((response: Response) => {
      this.products = response.data;
    });
  }

  createNewProduct() {
    this.http.post<Response>(CONSTANTS.apiURL + "/product", this.newProduct).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.getProducts();
      } else {
        alert(response.message);
      }
    });
  }

}
