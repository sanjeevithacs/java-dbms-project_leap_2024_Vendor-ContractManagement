import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.util.*;

public class Crud_sys {

	public static void main(String[] args) throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usecase","root","W7301@jqir#");
			System.out.println("Connection Successfully..");
			
//			String vendorSql = "INSERT INTO Vendor (vendor_id, name, contact_info) VALUES (?, ?, ?)";
//            PreparedStatement vendorStatement = con.prepareStatement(vendorSql);
//            vendorStatement.setString(1, "V001");
//            vendorStatement.setString(2, "ABC Catering");
//            vendorStatement.setString(3, "1234 Catering St, City, Country");
//            vendorStatement.executeUpdate();
//            System.out.println("Vendor record created.");

            
//            String contractSql = "INSERT INTO Contract (contract_id, vendor_id, start_date, end_date, cost, status) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement contractStatement = con.prepareStatement(contractSql);
//            contractStatement.setString(1, "C001");  
//            contractStatement.setString(2, "V001"); 
//            contractStatement.setDate(3, java.sql.Date.valueOf("2024-11-15"));  
//            contractStatement.setDate(4, java.sql.Date.valueOf("2024-11-20")); 
//            contractStatement.setDouble(5, 1500.00);  
//            contractStatement.setString(6, "Active"); 
//            contractStatement.executeUpdate();
//            System.out.println("Contract record created.");
//        
            
//            String selectSql = "SELECT c.contract_id, c.start_date, c.end_date, c.cost, c.status, v.name AS vendor_name "
//                    + "FROM Contract c JOIN Vendor v ON c.vendor_id = v.vendor_id WHERE c.vendor_id = ?";
//            PreparedStatement selectStatement = con.prepareStatement(selectSql);
//            selectStatement.setString(1, "V001"); 
//            ResultSet result = selectStatement.executeQuery();
//            while (result.next()) {
//                System.out.println("Contract ID: " + result.getString("contract_id"));
//                System.out.println("Vendor Name: " + result.getString("vendor_name"));
//                System.out.println("Start Date: " + result.getDate("start_date"));
//                System.out.println("End Date: " + result.getDate("end_date"));
//                System.out.println("Cost: " + result.getDouble("cost"));
//                System.out.println("Status: " + result.getString("status"));
//            }


//			 String updateSql = "UPDATE Contract SET status = ? WHERE contract_id = ?";
//	            PreparedStatement updateStatement = con.prepareStatement(updateSql);
//	            updateStatement.setString(1, "Completed");
//	            updateStatement.setString(2, "C001"); 
//	            updateStatement.executeUpdate();
//	            System.out.println("Contract status updated.");

			
//			String deleteContractSql = "DELETE FROM Contract WHERE vendor_id = ?";
//            PreparedStatement deleteContractStatement = con.prepareStatement(deleteContractSql);
//            deleteContractStatement.setString(1, "V001");
//            deleteContractStatement.executeUpdate();
//            System.out.println("Contracts related to the vendor deleted.");

			String deleteVendorSql = "DELETE FROM Vendor WHERE vendor_id = ?";
            PreparedStatement deleteVendorStatement = con.prepareStatement(deleteVendorSql);
            deleteVendorStatement.setString(1, "V001");
            deleteVendorStatement.executeUpdate();
            System.out.println("Vendor record deleted.");


			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
