/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//anna
import java.io.*;
import java.util.ArrayList;

public class Rating implements Serializable {
    private static final long serialVersionUID = 18L;
   
    
    private final int ratingID; 
    private int driverRating; // 
    private int userRating; 
    private String review;
    
    public Rating() {
        this.ratingID = -1;
    }

    public Rating(int ratingID, int driverRating, int userRating, String review) {
        this.ratingID = ratingID;
        this.driverRating = driverRating;
        this.userRating = userRating;
        this.review = review;
    }

    public int getRatingID() {
        return ratingID;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public int getUserRating() {
        return userRating;
    }
    
    public void setDriverRating(int r) {
        driverRating = r;
    }
    
    public void setUserRating(int userRating) {

        this.userRating = userRating;
    }
    
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void viewRating() {
        System.out.println("Driver Rating: " + driverRating + "/5");
        System.out.println("User Rating: " + userRating + "/5");
        System.out.println("Review: " + review);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rating rt = (Rating) obj;
        return ratingID == rt.ratingID;
    }

 
    @Override
        public String toString(){
            return "Driver Rating is:" +driverRating; 

}

}