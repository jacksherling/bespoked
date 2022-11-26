import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Customer } from '../entities';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  @Input() customer!: Customer;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    console.log(this.customer)
  }

}
