import { HttpClient } from '@angular/common/http';
import { Component, Injectable, Input, OnInit } from '@angular/core';
import { Salesperson, SalespersonReport } from '../entities';
import { CONSTANTS, Response } from '../util';

@Injectable()
@Component({
  selector: 'app-salesperson',
  templateUrl: './salesperson.component.html',
  styleUrls: ['./salesperson.component.css']
})
export class SalespersonComponent implements OnInit {

  @Input() salesperson!: Salesperson;
  @Input() reload!: Function;

  editing: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    console.log(this.salesperson)
  }

  switchEditing() {
    this.editing = !this.editing;
  }

  save() {
    this.http.post<Response>(CONSTANTS.apiURL + "/salesperson", this.salesperson).subscribe((response: Response) => {
      console.log(response)
      if (response.message == "Success") {
        this.reload();
        this.switchEditing();
      }
    });
  }

}
