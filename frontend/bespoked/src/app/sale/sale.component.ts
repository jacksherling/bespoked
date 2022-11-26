import { Component, Input, OnInit } from '@angular/core';
import { Sale } from '../entities';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {

  @Input() sale!: Sale;

  constructor() { }

  ngOnInit(): void {
  }

}
