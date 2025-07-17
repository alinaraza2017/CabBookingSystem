/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

//alina
//abstraction istamaal
import java.io.*;
abstract public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String name;
    protected Phone phoneNum; //containership is being used here
    protected Email email;
    //default coonstructor
    User(){
    
    }
    //login keliye constructor
    User(Phone p,Email e){
        phoneNum=p;
        email=e;
        
    }
    //parametrized constructor
    User(String n,Phone pn,Email e){
        name=n;
        // Check phone and email validity and assigning null if invalid
        if (Phone.verifyPhone(pn.toString())) {
            phoneNum = pn;
        } else {
            System.out.println("Invalid phone number.");
            phoneNum=null; // Default or null
        }
        
        if (Email.emailValid(e.getEmail())) {
            email = e;
        } else {
            System.out.println("Invalid email.");
            email=null; // Default or null
        }
    }
    //setters and getters methods
    public void setName(String a){ 
        name = a ;
    }
    public String getName() {
        return name ;
    }
    public void setPhone(Phone phoneNum) {
        if (Phone.verifyPhone(phoneNum.toString())) {
            this.phoneNum = phoneNum;
        } else {
            System.out.println("Invalid phone number");
        }
    }
    public Phone getPhone() {
        return phoneNum ;
    }
    public void setEmail(Email email) {
        if (Email.emailValid(email.getEmail())) {
            this.email = email;
        } else {
            System.out.println("Invalid email format");
        }
    }
    public Email getEmail() {
        return email ;
    }
   
    abstract void displayDetails();
    
    @Override
    public String toString(){
        return "name: "+name+"\nphone number: "+phoneNum+"\nemail: "+email;
    }
    
    public abstract boolean login(Email email,Phone phone);

    public abstract void signup(Email email,Phone phone,String name);
        
    }
  


