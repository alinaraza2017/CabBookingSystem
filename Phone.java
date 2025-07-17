/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;
//alina
import java.io.*;
public class Phone implements Serializable {
    private static final long serialVersionUID =19L;
    private String phone;
    
    Phone(){
        
    }
    Phone(String p){
        phone=p;
    }
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String p){
        phone=p;
    }
    
    @Override
    public String toString(){
        return phone;
    }
  
     //method to verify the phone number
    public static boolean verifyPhone(String p){
        if(p.length()!=11){
            return false;
        }
        else{
            String invalid="~!@#$%^&()_`|\\\\[]{};:\\\"',.<>/?=+-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i=0;i<p.length();i++)
                for(int j=0;j<invalid.length();j++)
                    if(p.charAt(i)==invalid.charAt(j)){
                        return false;
                }
        }
        
    return true;
    }
  }



    


