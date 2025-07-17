/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//filehandling rehti isski

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */
import java.io.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


public class Driver extends User implements Serializable{
    
    private static final long serialVersionUID = 3L; // Add serialVersionUID for compatibility
    private Rating rating;
    private Vehicle vehicle;
    private boolean rideAccepted;
    public ArrayList<Driver> drivers = new ArrayList<>();
    public DriverHandler driverHandler=new DriverHandler(); 
    
    
    Driver(){
        
        }
    
    
    Driver(Phone phone,Email email){
        super(phone,email);
    }
    
    Driver(String n,Phone p,Email e){
        super(n,p,e);
        this.rating = new Rating(); //ADDED THIS LINE

    }
    Driver(String n,Phone p,Email e,Rating r,Vehicle v, boolean available){
      super(n,p,e);
      rating=r;
      vehicle=v;
      rideAccepted = !available;
     
    }
    
   
    public void setRating(Rating a){ 
        Rating rating=new Rating(07,2,4,"cud be better");
    }
    public Rating getRating() {
        Rating rating=new Rating(07,2,4,"cud be better");
        return rating; 
    }
    public void setVehicle(Vehicle a){ 
        vehicle = a ;
    }
    public Vehicle getVehicle() {
    return vehicle;
}

    public boolean acceptRide(){
        if (rideAccepted) {
            System.out.println("Driver " +name + " is not available");
            return false;
        }
        rideAccepted = true;
        System.out.println("Ride accepted by driver " + name + ".");
        return true;
    }

   
    @Override
public String toString() {
    return "Name: " + name + ", Email: " + email.getEmail() + ", Rating: " + rating;
}

    @Override
    public void displayDetails(){
        super.toString();
        System.out.println("Vehicle: " +vehicle + " Rating: " +rating.getDriverRating());
    }
    
    @Override
    public boolean login(Email email, Phone phone) {
        ArrayList<Driver> driversFromFile = driverHandler.readFromFile(); // Read all customers from the file
        if (driversFromFile != null) {
            for (Driver drivers : driversFromFile) {
                if(drivers.getEmail().equals(email)||drivers.getPhone().equals(phone)) {
                    System.out.println("Driver logged in successfully.");
                    return true; 
                }
            }
        }
        return false; 
    }

    
   
    public void signup(Email email,Phone phone,String name) {
        // Check if customer already exists
        Driver newDriver = new Driver(name, phone, email);
        ArrayList<Driver> drivers = new ArrayList<>();
        
        
        
        if ( drivers != null) {
            //for each loop for basically traversing through the arraylist
            for (Driver d : drivers ) {
                if (d.getEmail().equals(email)|| d.getPhone().equals(phone)) {
                    System.out.println("Customer with this email/phone already exists. Please login.");
                    return;
                }
            }
            driverHandler.saveData(newDriver);
        } else {
            driverHandler.saveData(newDriver); 
        }
        System.out.println("Signup successful! You can now login.");
    }

public static void main(String[] args) {
    
    Phone p1 = new Phone("12345678765");
    Email e1 = new Email("alina.raza2017@gmail.com");
    Driver d1 = new Driver("alina", p1, e1);
    Driver d2= new Driver("ahad", p1, e1);
    
    // Save data to file
    
    d1.drivers.add(d1);
    d1.drivers.add(d2);
    
    

    
}

 
}
