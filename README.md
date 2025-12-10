# Vendor-ContractManagement (Java + MySQL)

A console-based Java application for managing vendors and their contracts for event management.
The system supports vendor registration, contract creation, updating details, and displaying records stored in a MySQL database.

## Features

- Register a new vendor
- View vendor details by vendor ID
- Update vendor address and contact information
- Create a contract linked to an existing vendor
- View contract details
- Update contract duration and contract information
- Display all registered vendors in table format

## Prerequisites

- Java JDK 11+
- MySQL Server installed
- MySQL JDBC Connector
- Any Java IDE (optional)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sanjeevithacs/java-dbms-project_leap_2024_Vendor-ContractManagement.git
   cd java-dbms-project_leap_2024_Vendor-ContractManagement


2.Create the MySQL database and tables:

```sql
CREATE DATABASE workusecase;
USE workusecase;

CREATE TABLE vendor (
  vendor_id INT PRIMARY KEY,
  vendor_name VARCHAR(255),
  vendor_type VARCHAR(255),
  address VARCHAR(255),
  contact VARCHAR(15)
);

CREATE TABLE contract (
  contract_id INT PRIMARY KEY AUTO_INCREMENT,
  vendor_id INT,
  start_date DATE,
  end_date DATE,
  contract_details TEXT,
  FOREIGN KEY (vendor_id) REFERENCES vendor(vendor_id)
);
```


3. Update your database connection in VendorContract.java:

``` java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/workusecase",
    "root",
    "YOUR_PASSWORD"
);
```

## Usage

1. Compile the Java files:

``` bash
javac -d out src/com/org/model/VendorContract.java \
src/com/org/service/Service.java \
src/com/org/service/ServiceImpl.java \
src/com/org/controller/VendorContractController.java
```

2. Run the application:

Windows
```bash
java -cp out;path/to/mysql-connector.jar com.org.controller.VendorContractController
```

Linux/Mac
```bash
java -cp out:path/to/mysql-connector.jar com.org.controller.VendorContractController
```

3. The console menu will appear. Use options to:

- Register vendors
- Create and update contracts
- View vendor or contract details
- Display all vendors

  ## Menu Options in Detail

- **Register Vendor**: Add vendor name, type, address, and contact
- **Update Vendor**: Modify address or contact number
- **Create Contract**: Enter dates and contract details
- **View Contract**: Retrieve contract info by ID
- **View All Vendors**: Prints all vendor records in formatted table

## Project Structure

```
Vendor-ContractManagement/
├── src/
│   └── com/org/
│       ├── controller/
│       │   └── VendorContractController.java
│       ├── model/
│       │   └── VendorContract.java
│       └── service/
│           ├── Service.java
│           └── ServiceImpl.java
├── README.md
└── (Add mysql-connector.jar if needed)
```



## Output Screenshot

<img width="523" height="484" alt="image" src="https://github.com/user-attachments/assets/eeacc383-4bd0-42d0-9291-e7019aa12fab" />
<img width="697" height="593" alt="image" src="https://github.com/user-attachments/assets/829f30b0-95f0-45fb-8efd-d4db578b5f05" />


## Dependencies

- Java (Core Java)
- MySQL
- JDBC Connector

## Contributing

Contributions are welcome!
Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License — see the LICENSE file for details.

## Disclaimer

This project is for academic and learning purposes.
Ensure sensitive database credentials are not committed to public repositories.
