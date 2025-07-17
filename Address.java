/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//ayesha 

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 99L;
    protected double latitude;
    protected double longitude;
    private String street;
    private String houseNumber;
    private String city;
    
    
    public Address(){
       
    }

    public Address(String street, String houseNumber, String city, double latitude, double longitude) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (isValidLatitude(latitude)) {
            this.latitude = latitude;
        } else {
            System.out.println("Invalid latitude value.");
        }
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (isValidLongitude(longitude)) {
            this.longitude = longitude;
        } else {
            System.out.println("Invalid longitude value.");
        }
    }

    
    protected boolean isValidLatitude(double latitude) {
        return latitude >= -90 && latitude <= 90;
    }

    protected boolean isValidLongitude(double longitude) {
        return longitude >= -180 && longitude <= 180;
    }

    
    @Override
    public String toString() {
        return "Address: " + street + " " + houseNumber + ", " + city + ", " + " [Lat: " + latitude + ", Lon: " + longitude + "]";
    }

}
