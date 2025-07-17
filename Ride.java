/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//Filehandler is not implemented here
//tehreem
import java.io.*;
import java.util.ArrayList;

public class Ride implements Serializable{
    private static final long serialVersionUID = 44L;
    private int rideID; // Directly set from User ID
    private Location pickup;
    private Location dropoff;
    private double fare;
    private String status;
    public RideHandler rideHandler=new RideHandler();
    
    Ride(){
        
    }

    // Constructor now takes userID to set the rideID
    public Ride(int userID, Location pickup, Location dropoff) {
        this.rideID = userID; // Set rideID as the userID
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.status = "Pending";
    }

    public double calculateFare(int waitTimeMinutes) {
        double distance = pickup.calculateDistance(dropoff); 
        fare = 10 + (distance * 0.5); // Minimum fare 10

        if (waitTimeMinutes > 5) {
            fare += (waitTimeMinutes - 5) * 0.5;
        }

        // Format fare to one decimal place
        fare = Double.parseDouble(String.format("%.1f", fare));
        return fare;
    }

    public double applyDiscount(double discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            fare -= (fare * (discountPercentage / 100));
            fare = Double.parseDouble(String.format("%.1f", fare));  
        }
        return fare;
    }

    public void startRide() {
        status = "Started";
    }

    public void setPending() {
        status = "Pending";
    }

    public String getStatus() {
        return status;
    }

    public int getRideID() {
        return rideID;
    }

    public double getFare() {
        return fare;
    }

    public String getFareDetails() {
        return "Fare from " + pickup.getAddress() + " to " + dropoff.getAddress() + " is Rs." + fare;
    }

    public Location getPickupLocation() {
        return pickup;
    }

    public Location getDropoffLocation() {
        return dropoff;
    }

    // Load ride history for a user from a file
    public ArrayList<Ride> loadRideHistory() {
        try {
            return rideHandler.readFromFile();
        } catch (Exception e) {
            System.err.println("Error loading ride history: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Save or append ride history for a user to a file
    public void saveRideHistory() {
        try {
            rideHandler.saveData(this);
        } catch (Exception e) {
            System.err.println("Error saving ride history: " + e.getMessage());
        }
    }
}