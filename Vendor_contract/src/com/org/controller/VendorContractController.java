package com.org.controller;

import com.org.model.VendorContract;
import com.org.service.Service;
import com.org.service.ServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

public class VendorContractController {

	private static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        VendorContract vendor = new VendorContract();

        try {
            // Initialize service
            Service sv = new ServiceImpl();
            vendor.db_connect();  // Assuming the Vendor model handles DB connection

            boolean exe = true;
            System.out.println("Connection successful..");

            while (exe) {
                System.out.println(" 1. Register Vendor \n 2. View Vendor Details \n 3. Update Vendor Info \n 4. Create Contract \n 5. View Contract \n 6. Update Contract \n 7. View All Vendors \n 8. Exit");
                int input = sn.nextInt();

                switch (input) {
                    case 1:
                        sv.registerVendor();  // Method to register a new vendor
                        System.out.println("Vendor Registered.");
                        break;

                    case 2:
                        sv.viewVendorDetails();  // Method to view vendor details
                        System.out.println("Vendor Details Viewed.");
                        break;

                    case 3:
                        sv.updateVendorInfo();  // Method to update vendor information
                        System.out.println("Vendor Info Updated.");
                        break;

                    case 4:
                        sv.createContract();  // Method to create a contract for a vendor
                        System.out.println("Contract Created.");
                        break;

                    case 5:
                        sv.viewContract();  // Method to view contract details
                        System.out.println("Contract Details Viewed.");
                        break;

                    case 6:
                        sv.updateContract();  // Method to update contract details
                        System.out.println("Contract Updated.");
                        break;

                    case 7:
                        sv.viewAllVendors();  // Method to view all vendor details
                        System.out.println("All Vendor Details Viewed.");
                        break;

                    case 8:
                        exe = false;
                        System.out.println("Exiting the system...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
