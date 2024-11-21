package com.org.service;

public interface Service {

	// Vendor Management Methods
    void registerVendor();             
    void viewVendorDetails();          
    void updateVendorInfo();           
    void viewAllVendors();             

    // Contract Management Methods
    void createContract();             
    void viewContract();               
    void updateContract();   
}
