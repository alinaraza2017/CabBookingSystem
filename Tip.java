/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//anna

import java.io.Serializable;

public class Tip implements Serializable{
    private static final long serialVersionUID = 54L;
   private double tipAmount;

    public Tip() {
        this.tipAmount = 0.0;
    }

    public void setTipAmount(double tipAmount) {
        if (tipAmount >= 0) {
            this.tipAmount = tipAmount;
        } else {
            System.out.println("Tip amount cannot be negative. Setting tip to 0.");
            this.tipAmount = 0.0;
        }
    }

    public double getTipAmount() {
        return tipAmount;
    }
}
