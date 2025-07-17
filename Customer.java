/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//alina
import java.io.*;
import java.util.ArrayList;

//customer has inherited from user
public class Customer extends User implements Serializable{   //serializable is an interface 
    private static final long serialVersionUID = 9L;
    private boolean rideBooked = true;
    //ride history
    private int customerid;
     //we have done final bcz it is going to be the only file of customers data
    
    Customer(){
        
    }
    
    Customer(Phone phone,Email email){
        super(phone,email);
    }
    
    Customer(String n,Phone p,Email e){
        super(n,p,e);
        
    }
    //setter and getter methods
    public void setCustomerID(int c){
        customerid=c;
    }
    public int getCustomerID(){
        return customerid;
    }

    public boolean bookRide(){
        if (!rideBooked) {
            System.out.println("A ride is already booked.");
            return false;
        }
        rideBooked = true;
        System.out.println("Ride successfully booked.");
        return true; 
    }
    public boolean cancelRide(){
        if (!rideBooked) {
            System.out.println("No ride to cancel.");
            return false;
        }
        rideBooked = false;
        System.out.println("Ride canceled.");
        return true;
    }
    @Override
    public void displayDetails(){
        super.toString();
        
    }
    
    
    @Override
    public boolean login(Email email, Phone phone) {
        CustomerHandler customer=new CustomerHandler();
        ArrayList<Customer> customersFromFile = customer.readFromFile(); // Read all customers from the file
        if (customersFromFile != null) {
            for (Customer customers : customersFromFile) {
                if(customers.getEmail().equals(email)||customers.getPhone().equals(phone)) {
                    System.out.println("Customer logged in successfully.");
                    return true; 
                }
            }
        }
        System.out.println("Login failed. Email not found.");
        return false; 
    }

    
    @Override
    public void signup(Email email,Phone phone,String name) {
        // Check if customer already exists
        Customer newCustomer = new Customer(name, phone, email);
        CustomerHandler ch=new CustomerHandler();
        ArrayList<Customer> customers = new ArrayList<>();
        
        
        
        if ( customers != null) {
            //for each loop for basically traversing through the arraylist
            for (Customer customer : customers ) {
                if (customer.getEmail().equals(email)|| customer.getPhone().equals(phone)) {
                    System.out.println("Customer with this email/phone already exists. Please login.");
                    return;
                }
            }
            ch.saveData(newCustomer);
        } else {
            ch.saveData(newCustomer); 
        }
        System.out.println("Signup successful! You can now login.");
    }
}
    


