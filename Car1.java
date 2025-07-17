/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//anna

import java.io.Serializable;

public class Car1 implements Serializable{
    private static final long serialVersionUID = 45L;
    private String carCompany;
    private String model;
    private String licensePlate;
    private int capacity;

    public Car1(String carCompany, String model, String licensePlate, int capacity) {
        this.carCompany = carCompany;
        this.model = model;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
}
    



