create database workusecase;
use workusecase;

CREATE TABLE vendor (
    vendor_id INT PRIMARY KEY,
    vendor_name VARCHAR(255),
    vendor_type VARCHAR(255),
    address VARCHAR(255),
    contact VARCHAR(15)
);
select * from vendor;

CREATE TABLE contract (
    contract_id INT PRIMARY KEY AUTO_INCREMENT,
    vendor_id INT,
    start_date DATE,
    end_date DATE,
    contract_details TEXT,
    FOREIGN KEY (vendor_id) REFERENCES vendor(vendor_id)
);
select * from contract;