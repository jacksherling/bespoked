import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../entities';
import { CONSTANTS, Response } from '../util';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input() product!: Product;
  @Input() reload!: Function;
  
  editing: boolean = false;
  
  constructor(private http: HttpClient) { }
  
  ngOnInit(): void {
    console.log(this.product)
  }
  
  switchEditing() {
    console.log("hi")
    this.editing = !this.editing;
  }
  
  save() {
    this.http.post<Response>(CONSTANTS.apiURL + "/product", this.product).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.reload();
        this.switchEditing();
      }
    });
  }

}


