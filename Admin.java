/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 7L;
    public ArrayList<Driver> drivers = new ArrayList<>(); // List of drivers
   
    private ArrayList<Ride> rides = new ArrayList<>(); // List of rides
    private String ADMIN_FILE = "admin.txt"; // Admin credentials file
    private String DATA_FILE = "adminData.txt";
    private static Admin currentAdmin; // Logged-in admin instance
    
    public DriverHandler driverFileHandler = new DriverHandler();
    
    private RideHandler rideFileHandler = new RideHandler();

    public Admin(Phone phone, Email email) {
        super(phone, email);
    }

    public Admin(String name, Phone phone, Email email) {
        super(name, phone, email);
    }

    @Override
    public boolean login(Email email, Phone phone) {
        Admin storedAdmin = readAdminFromFile();
        if (storedAdmin != null && storedAdmin.getEmail().equals(email) && storedAdmin.getPhone().equals(phone)) {
            System.out.println("Admin logged in successfully.");
            currentAdmin = storedAdmin;
            return true;
        }
        System.out.println("Login failed. Invalid email or phone.");
        return false;
    }

    @Override
    public void signup(Email email, Phone phone, String name) {
        throw new UnsupportedOperationException("Signup is not allowed for Admin.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Admin Details: " + super.toString());
    }

    public boolean removeDriver(String driverName) {
        drivers=driverFileHandler.readFromFile();
        boolean removed = drivers.removeIf(driver -> driver.name.equals(driverName));
        if (removed) {
            driverFileHandler.writeDataToFile(drivers);
            System.out.println("Driver removed successfully: " + driverName);
            return true;
        } else {
            System.out.println("Driver not found: " + driverName);
            return false;
        }
       
    }

    private void askForValidDriverName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a valid driver name to remove: ");
        String driverName = scanner.nextLine();
        removeDriver(driverName);  // Retry removing the driver
    }

  public void viewAllDrivers() { //CHANGED RETURN TYPE
    System.out.println("Loading all drivers...");
    ArrayList<Driver> driverList = driverFileHandler.readFromFile();
   
        for (Driver driver: driverList){
            System.out.println("Driver: " + driver.name + "Driver phone number: " +driver.phoneNum + " Driver email: " +driver.email + "Driver rating: " +driver.getRating());
        
    }
}

    public void viewDriverRatings() {
        System.out.println("----- Driver Ratings -----");
        ArrayList<Driver> driverread = driverFileHandler.readFromFile();
        for (Driver driver : driverread){
            System.out.println("Driver: " + driver.name + ", Rating: " + driver.getRating());
        }
    }

    // 4. ANALYTICS DASHBOARD
    public void displayTopDrivers() {
        System.out.println("----- Top Drivers by Rating -----");

        // Sort drivers list by ratings in descending order
        // drivers.sort((d1, d2) -> Double.compare(d2.getRating(), d1.getRating()));

        // Display the top 3 drivers
        for (int i = 0; i < Math.min(3, drivers.size()); i++) {
            Driver driver = drivers.get(i);
            System.out.println("Driver: " + driver.name + ", Rating: " + driver.getRating());
        }
    }

    // Serialization: Save data to a file automatical

    // Deserialization: Load data automatically when Admin is initialized
    private Admin readAdminFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ADMIN_FILE))) {
            return (Admin) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No admin data found. Please initialize admin.");
            return null;
        }
    }
 

    public static void initializeAdmin(String name, Phone phone, Email email) {
        Admin admin = new Admin(name, phone, email);
        System.out.println("Admin initialized successfully.");
    }
}