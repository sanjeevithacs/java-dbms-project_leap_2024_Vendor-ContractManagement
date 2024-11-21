package com.org.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VendorContract {

	public static Connection db_connect() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/workusecase","root","W7301@jqir#");
	}

}
