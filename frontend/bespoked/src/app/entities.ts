export interface Salesperson {
    id?: number;
    firstName?: String;
    lastName?: String;
    address?: String;
    phone?: String;
    startDate?: String;
    terminationDate?: String;
    manager?: String;
}

export interface Product {
    id?: number;
    name?: String;
    manufacturer?: String;
    style?: String;
    purchasePrice?: number;
    salePrice?: number;
    qtyOnHand?: number;
    commissionPercentage?: number;
}

export interface Customer {
    id?: number;
    firstName?: String;
    lastName?: String;
    address?: String;
    phone?: String;
}

export interface Sale {
    id?: number;
    price?: number;
    salesDate?: String;
    product?: Product;
    customer?: Customer;
    salesperson?: Salesperson;
}

export interface Discount {
    id?: number;
    product?: Product;
    beginDate?: String;
    endDate?: String;
    discountPercentage?: number;
}

export interface SalespersonReport {
    salesperson: Salesperson;
    commission: number;
    sales: number;
}