import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Sale, Salesperson, SalespersonReport } from '../entities';
import { CONSTANTS, Quarter, QuarterResponse } from '../util';

@Injectable()
@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  // year: Number = 2022;
  // quarter: Number = 1;

  quarter: Quarter = { quarter: 1, year: 2022 };

  salespeople: Salesperson[] = [];
  sales: Sale[] = [];

  reports: SalespersonReport[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.http.post<QuarterResponse>(CONSTANTS.apiURL + "/report", this.quarter).subscribe((response: QuarterResponse) => {
      console.log(response)
      this.salespeople = response.salespeople;
      this.sales = response.sales;
      this.generateReport();
    });
  }

  generateReport() {
    let map: Map<number, SalespersonReport> = new Map<number, SalespersonReport>();
    this.salespeople.forEach(s => {
      console.log(s)
      map.set(s.id!, {
        salesperson: s,
        commission: 0,
        sales: 0
      });
    });
    this.sales.forEach(s => {
      let report: SalespersonReport = map.get(s.salesperson?.id || 0)!;
      report.sales++;
      report.commission += s.price! * s.product!.commissionPercentage!;
    });
    this.reports = Array.from(map).map(v => v[1]);
    console.log(this.reports)
  }

}
