--SEED DATA FOR BESPOKED APPLICATION

DROP DATABASE IF EXISTS bespoked;
CREATE DATABASE bespoked;

--Make sure to create bespoked DB in sql and run BespokedApplication before running the following commands!

USE bespoked;

INSERT INTO customer (id, first_name, last_name, address, phone, start_date) VALUES (1000, "Jane", "Doe", "1234", "123-456-7890", "2015-05-06");
INSERT INTO customer (id, first_name, last_name, address, phone, start_date) VALUES (2000, "Eileen", "Roth", "5432", "523-541-4212", "2021-09-01");

INSERT INTO salesperson (id, first_name, last_name, address, phone, start_date, termination_date, manager) VALUES (1000, "Matthew", "Riley", "5821", "521-134-5123", "2011-02-21", "2019-05-08", "John Smith");
INSERT INTO salesperson (id, first_name, last_name, address, phone, start_date, termination_date, manager) VALUES (2000, "Carol", "Benton", "9182", "924-214-1221", "2022-10-15", "2026-11-15", "Kevin Collins");

INSERT INTO product (id, name, manufacturer, style, purchase_price, sale_price, qty_on_hand, commission_percentage) VALUES (1000, "General Bike", "Fair Manufacturers", "Road", 100, 129, 10, 0.5);
INSERT INTO product (id, name, manufacturer, style, purchase_price, sale_price, qty_on_hand, commission_percentage) VALUES (2000, "Cool Bike", "Great Manufacturers", "Mountain", 200, 256, 1, 0.2);

INSERT INTO discount (id, product_foreign_key, begin_date, end_date, discount_percentage) VALUES (1000, 1000, "2020-02-21", "2021-06-12", 0.5);

INSERT INTO sale (id, price, product_foreign_key, salesperson_foreign_key, customer_foreign_key, sales_date) VALUES (1000, 100, 1000, 1000, 1000, "2017-03-18");
INSERT INTO sale (id, price, product_foreign_key, salesperson_foreign_key, customer_foreign_key, sales_date) VALUES (2000, 200, 2000, 2000, 2000, "2022-10-28");

