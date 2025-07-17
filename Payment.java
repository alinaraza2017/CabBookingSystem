/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

import java.io.Serializable;


//tehreem class
public class Payment implements Serializable{
    private static final long serialVersionUID = 60L;
    private String paymentStatus;
    private String paymentMethod;
    private UserAccount user;
    private double tipAmount; // Field for tip

    public Payment() {
        
    }

    public Payment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pending";
        this.tipAmount = 0; // Initialize tip to 0
    }

    public boolean processPayment(UserAccount user, double rideCost) {
        if (paymentMethod.equalsIgnoreCase("cash")) {
            paymentStatus = "Done";
            return true;
        } else if (paymentMethod.equalsIgnoreCase("card")) {
            if (user.getBalance() >= rideCost) {
                user.deductAmount(rideCost);
                paymentStatus = "Done";
                return true;
            } else {
                paymentStatus = "Failed";
                return false;
            }
        }
        return false;
    }

    // New tip method to deduct tip from the user account
    public boolean tip(double tipAmount) {
        if (tipAmount > 0 && user.getBalance() >= tipAmount) {
            user.deductAmount(tipAmount); // Deduct the tip amount from user balance
            this.tipAmount = tipAmount; // Store the tip amount
            return true; // Tip successfully deducted
        }
        return false; // Tip deduction failed (insufficient balance)
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTipAmount() {
        return tipAmount;
    }
}