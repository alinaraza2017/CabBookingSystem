/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//tehreem

import java.io.Serializable;

public class UserAccount implements Serializable {
    private static final long serialVersionUID = 35L;
     private double balance;

    public UserAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

}
