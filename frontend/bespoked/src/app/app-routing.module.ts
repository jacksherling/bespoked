import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers/customers.component';
import { DiscountsComponent } from './discounts/discounts.component';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { ReportComponent } from './report/report.component';
import { SalesComponent } from './sales/sales.component';
import { SalespeopleComponent } from './salespeople/salespeople.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "salespeople", component: SalespeopleComponent },
  { path: "products", component: ProductsComponent },
  { path: "customers", component: CustomersComponent },
  { path: "sales", component: SalesComponent },
  { path: "discounts", component: DiscountsComponent },
  { path: "report", component: ReportComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
