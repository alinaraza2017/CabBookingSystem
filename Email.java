/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//alina

import java.io.Serializable;

public class Email implements Serializable{
    private static final long serialVersionUID = 14L;
    private String email;
    
    Email(){
        
    }
    Email(String e){
        email=e;
    }
    public void setEmail(String p){
        email=p;
    }
    public String getEmail(){
        return email;
    }
  
    //method to check email validity
    public static boolean emailValid(String s){
        String s1="@";
        String s2=".com";
        if(s.length()>9){
            for(int i=0;i<s.length();i++)
                if(s.contains(s1) && s.contains(s2)){
                    return true;
              }
        } 
        return false;
    }
    @Override
    public String toString() {
    return email; 
}
}

    



