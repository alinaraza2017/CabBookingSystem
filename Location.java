/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;


//ayesha class
import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = 75L;
    private String address;
    private double latitude;
    private double longitude;

    public Location(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public double calculateDistance(Location other) {
        // Simple distance calculation between two locations
        double xDiff = this.latitude - other.latitude;
        double yDiff = this.longitude - other.longitude;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}