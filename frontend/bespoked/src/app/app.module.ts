import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SalespeopleComponent } from './salespeople/salespeople.component';
import { CustomersComponent } from './customers/customers.component';
import { SalesComponent } from './sales/sales.component';
import { DiscountsComponent } from './discounts/discounts.component';
import { ReportComponent } from './report/report.component';
import { HttpClientModule } from '@angular/common/http';
import { SalespersonComponent } from './salesperson/salesperson.component';
import { FormsModule } from '@angular/forms';
import { CustomerComponent } from './customer/customer.component';
import { ProductsComponent } from './products/products.component';
import { ProductComponent } from './product/product.component';
import { SaleComponent } from './sale/sale.component';
import { DiscountComponent } from './discount/discount.component';
import { SalespersonreportComponent } from './salespersonreport/salespersonreport.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SalespeopleComponent,
    CustomersComponent,
    SalesComponent,
    DiscountsComponent,
    ReportComponent,
    SalespersonComponent,
    CustomerComponent,
    ProductsComponent,
    ProductComponent,
    SaleComponent,
    DiscountComponent,
    SalespersonreportComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
