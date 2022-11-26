import { Component, Input, OnInit } from '@angular/core';
import { SalespersonReport } from '../entities';

@Component({
  selector: 'app-salespersonreport',
  templateUrl: './salespersonreport.component.html',
  styleUrls: ['./salespersonreport.component.css']
})
export class SalespersonreportComponent implements OnInit {

  @Input() salespersonReport!: SalespersonReport;

  constructor() { }

  ngOnInit(): void {
  }

}
