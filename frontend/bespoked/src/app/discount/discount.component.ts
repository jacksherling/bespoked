import { Component, OnInit, Input } from '@angular/core';
import { Discount, Product } from '../entities';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-discount',
  templateUrl: './discount.component.html',
  styleUrls: ['./discount.component.css']
})
export class DiscountComponent implements OnInit {

  @Input() discount!: Discount;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    console.log(this.discount)
  }

}
