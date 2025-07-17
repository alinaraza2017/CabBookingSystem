/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//anna

import java.io.Serializable;


public class Vehicle extends Car1 implements Serializable {
    private static final long serialVersionUID = 11L;
   private int availableCars;
    private String status; 
   

    public Vehicle() {
        super("Toyota", "Corolla", "CGB-098", 5); 
        this.availableCars = 100;
        this.status = "Available";
    }

    public Vehicle(int cars, String carCompany, String model, String licensePlate, int capacity, String status) {
        super(carCompany, model, licensePlate, capacity);
        this.availableCars = cars;
        this.status = status;
    }

    public int getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(int availableCars) {
        this.availableCars = availableCars;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isRideAvailable() {
        return availableCars > 0 && status.equalsIgnoreCase("available");
    }

    public String getVehicleDetails() {
        return "Car Company: " + getCarCompany() + ", Model: " + getModel() + 
               ", License Plate: " + getLicensePlate() + ", Capacity: " + getCapacity() + 
               ", Status: " + status;
    }
    @Override
    public String toString() {
        return getVehicleDetails();
    }

   
   }
