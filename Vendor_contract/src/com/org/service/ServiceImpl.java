package com.org.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.org.model.VendorContract;

public class ServiceImpl implements Service{
	
	 private static Scanner sn = new Scanner(System.in);

	    @Override
	    public void registerVendor() {
	        try {
	            Connection conn = VendorContract.db_connect();

	            System.out.println("Enter vendor id:");
	            int vendorId = sn.nextInt();

	            System.out.println("Enter vendor name:");
	            String name = sn.next();

	            System.out.println("Enter vendor type (1. Supplier 2. Service Provider):");
	            int typeId = sn.nextInt();
	            String type = (typeId == 1) ? "Supplier" : "Service Provider";

	            System.out.println("Enter vendor address:");
	            String address = sn.next();

	            System.out.println("Enter vendor contact number:");
	            String contact = sn.next();

	            String sql = "INSERT INTO vendor(vendor_id, vendor_name, vendor_type, address, contact) VALUES (?,?,?,?,?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, vendorId);
	            pstmt.setString(2, name);
	            pstmt.setString(3, type);
	            pstmt.setString(4, address);
	            pstmt.setString(5, contact);
	            pstmt.executeUpdate();

	            System.out.println("Vendor registered successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void viewVendorDetails() {
	        try {
	            System.out.println("Enter vendor id:");
	            int vendorId = sn.nextInt();
	            Connection conn = VendorContract.db_connect();
	            String sql = "SELECT * FROM vendor WHERE vendor_id = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, vendorId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                System.out.println("Vendor ID: " + rs.getInt("vendor_id"));
	                System.out.println("Vendor Name: " + rs.getString("vendor_name"));
	                System.out.println("Vendor Type: " + rs.getString("vendor_type"));
	                System.out.println("Address: " + rs.getString("address"));
	                System.out.println("Contact: " + rs.getString("contact"));
	            } else {
	                System.out.println("Vendor not found.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void updateVendorInfo() {
	        try {
	            System.out.println("Enter vendor id:");
	            int vendorId = sn.nextInt();

	            System.out.println("Enter new address:");
	            String address = sn.next();

	            System.out.println("Enter new contact number:");
	            String contact = sn.next();

	            Connection conn = VendorContract.db_connect();
	            String sql = "UPDATE vendor SET address = ?, contact = ? WHERE vendor_id = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, address);
	            pstmt.setString(2, contact);
	            pstmt.setInt(3, vendorId);
	            pstmt.executeUpdate();

	            System.out.println("Vendor information updated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void createContract() {
	        try {
	            System.out.println("Enter contract id:");
	            int contractId = sn.nextInt();

	            System.out.println("Enter vendor id:");
	            int vendorId = sn.nextInt();

	            System.out.println("Enter contract details:");
	            String details = sn.next();

	            System.out.println("Enter contract start date (YYYY-MM-DD):");
	            String startDate = sn.next();

	            System.out.println("Enter contract end date (YYYY-MM-DD):");
	            String endDate = sn.next();

	            Connection conn = VendorContract.db_connect();
	            String sql = "INSERT INTO contract(contract_id, vendor_id, contract_details, start_date, end_date) VALUES (?,?,?,?,?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, contractId);
	            pstmt.setInt(2, vendorId);
	            pstmt.setString(3, details);
	            pstmt.setString(4, startDate);
	            pstmt.setString(5, endDate);
	            pstmt.executeUpdate();

	            System.out.println("Contract created successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void viewContract() {
	        try {
	            System.out.println("Enter contract id:");
	            int contractId = sn.nextInt();
	            Connection conn = VendorContract.db_connect();
	            String sql = "SELECT * FROM contract WHERE contract_id = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, contractId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                System.out.println("Contract ID: " + rs.getInt("contract_id"));
	                System.out.println("Vendor ID: " + rs.getInt("vendor_id"));
	                System.out.println("Contract Details: " + rs.getString("contract_details"));
	                System.out.println("Start Date: " + rs.getString("start_date"));
	                System.out.println("End Date: " + rs.getString("end_date"));
	            } else {
	                System.out.println("Contract not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void updateContract() {
	        try {
	            System.out.println("Enter contract id:");
	            int contractId = sn.nextInt();
	            sn.nextLine();

	            System.out.println("Enter new contract details:");
	            String details = sn.next();

	            System.out.println("Enter new contract start date (YYYY-MM-DD):");
	            String startDate = sn.next();

	            System.out.println("Enter new contract end date (YYYY-MM-DD):");
	            String endDate = sn.next();

	            Connection conn = VendorContract.db_connect();
	            String sql = "UPDATE contract SET contract_details = ?, start_date = ?, end_date = ? WHERE contract_id = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, details);
	            pstmt.setString(2, startDate);
	            pstmt.setString(3, endDate);
	            pstmt.setInt(4, contractId);
	            pstmt.executeUpdate();

	            System.out.println("Contract updated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		@Override
		public void viewAllVendors() {
			try {
		        Connection conn = VendorContract.db_connect();
		        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM vendor", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ResultSet rs = pstmt.executeQuery();

		        if (!rs.next()) {
		            System.out.println("No vendor records found.");
		        } else {
		            rs.beforeFirst();
		            System.out.println("Vendor ID | Vendor Name | Vendor Type | Vendor Address | Vendor Contact Number");

		            while (rs.next()) {
		                int vendorId = rs.getInt("vendor_id");
		                String vendorName = rs.getString("vendor_name");
		                String vendorType = rs.getString("vendor_type");
		                String vendorAddress = rs.getString("address");
		                String vendorContact = rs.getString("contact");

		                System.out.println(vendorId + " | " + vendorName + " | " + vendorType + " | " + vendorAddress + " | " + vendorContact);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }		}

}
