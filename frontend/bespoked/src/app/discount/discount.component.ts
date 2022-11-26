import { Component, OnInit, Input } from '@angular/core';
import { Discount, Product } from '../entities';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CONSTANTS, Response } from '../util';

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
