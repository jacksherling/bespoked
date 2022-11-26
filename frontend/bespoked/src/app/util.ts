import { Salesperson, Sale } from "./entities";

export const CONSTANTS = {
    apiURL: "http://localhost:8080"
}

export interface Quarter {
    year?: number;
    quarter?: number;
}

export interface Response {
    message: String;
    data: any;
}

export interface QuarterResponse {
    message: String;
    salespeople: Salesperson[];
    sales: Sale[];
}